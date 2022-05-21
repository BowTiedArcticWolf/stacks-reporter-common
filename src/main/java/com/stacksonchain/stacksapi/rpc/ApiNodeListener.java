package com.stacksonchain.stacksapi.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Slf4j
@RequiredArgsConstructor
public class ApiNodeListener {

  final String endpoint;
  @Data
  static class RpcResult {
    @JsonProperty("jsonrpc")
    String version;
    @JsonProperty("id")
    String id;
    @JsonProperty("error")
    ErrorInfo errorInfo;
  }

  static @Data
  class ErrorInfo {
    String message;
    String code;
    Object data;
  }

  @Setter
  Consumer<ApiNodeListener> subscribeCallback = null;

  private final Map<Integer, Command> commands = new ConcurrentHashMap<>();
  private final Map<String, Command> subs = new ConcurrentHashMap<>();

  private final AtomicInteger counter = new AtomicInteger(1);
  private final BlockingQueue<JsonNode> messageQueue = new LinkedBlockingQueue<>();
  private final Semaphore socketSem = new Semaphore(1, true);


  @SneakyThrows
  public void runCommand(Command command) {
    int cnt = counter.addAndGet(1);
    var rpcRequest = mapper.createObjectNode();
    rpcRequest.put("jsonrpc", "2.0");
    rpcRequest.put("id", "" + cnt);
    rpcRequest.put("method", command.getMethod());
    rpcRequest.set("params", command.getParams());
    commands.put(cnt, command);
    subs.put(command.getSubscriber(), command);
    messageQueue.put(rpcRequest);
  }

  public void start() {
    new Thread(() -> {
      while (true) {
        try {
          socketSem.acquire();
          log.info("Proceed to create a new websocket");

          if (subscribeCallback != null) {
            subscribeCallback.accept(this);
          }

          var client = new OkHttpClient.Builder()
              .connectTimeout(10, TimeUnit.SECONDS)
              .writeTimeout(1, TimeUnit.SECONDS)
              .readTimeout(1, TimeUnit.SECONDS)
              .build();
          var socket = createWebSocket(client);
          while (true) {
            try {
              var req = messageQueue.take();
              if (req.get("completed") == null) {
                var content = mapper.writeValueAsString(req);
                log.info("sending: {}", content);
                socket.send(content);
              } else {
                break;
              }
            } catch (Exception ex) {
              /* ignore */
              log.error("Exception during websocket processing: ", ex);
            }
          }
        } catch (InterruptedException e) {
          log.error("Interrupted websocket loop, exiting", e);
          return;
        }
      }
    }).start();
  }

  WebSocket createWebSocket(OkHttpClient client) {
    var setupRequest = new Request.Builder()
        .url(endpoint + "/extended/v1/ws")
        .build();
    var socket = client.newWebSocket(setupRequest, new WebSocketListener() {
      @Override
      public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
      }

      @Override
      @SneakyThrows
      public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
        log.debug("Received: {}", text);
        try {
          var rpc = mapper.readValue(text, RpcResult.class);
          if (rpc.id != null) {
            var id = Integer.parseInt(rpc.id);
            if (commands.containsKey(id)) {
              var command = commands.get(id);
              if (rpc.errorInfo != null) {
                command.onError(rpc.errorInfo.message);
              }
              commands.remove(id);
            }
          } else {
            var result = mapper.readValue(text, RpcMethodResult.class);
            String method = "";
            if (result instanceof MempoolMethodResult) {
              method = "mempool";
            } else if (result instanceof BlockMethodResult) {
              method = "block";
            } else if (result instanceof MicroblockMethodResult) {
              method = "microblock";
            } else {
              log.info("unknown response: {}", result);
            }
            if (!method.equals("")) {
              subs.get(method).onEvent(result);
            }
          }
        } catch (Exception ex) {
          log.error("exception", ex);
        }
      }

      @Override
      @SneakyThrows
      public void onClosed(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        log.error("closed: {}", reason);
        /* re-create the socket */
        messageQueue.put(completeObject());
        socketSem.release();
      }

      @Override
      public void onClosing(@NotNull WebSocket webSocket, int code, @NotNull String reason) {
        log.error("closing: {}", reason);
      }

      @Override
      @SneakyThrows
      public void onFailure(@NotNull WebSocket webSocket, @NotNull Throwable t,
          @Nullable Response response) {
        log.error("failure: {} {}", response, t.getMessage());
        /* re-create the socket */
        messageQueue.put(completeObject());
        socketSem.release();
      }
    });
    return socket;
  }

  JsonNode completeObject() {
    var node = mapper.createObjectNode();
    node.put("completed", true);
    return node;
  }

  static ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
}
