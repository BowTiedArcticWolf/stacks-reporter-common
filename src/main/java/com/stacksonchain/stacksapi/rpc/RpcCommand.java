package com.stacksonchain.stacksapi.rpc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class RpcCommand implements Command {
  final String method;
  final String event;

  @Override
  public String getMethod() {
    return method;
  }

  @Override
  public JsonNode getParams() {
    var params = mapper.createObjectNode();
    params.put("event", event);
    return params;
  }

  ObjectMapper mapper = new ObjectMapper();

  public static <T extends RpcMethodResult> RpcCommand subscribe(String event,
      Consumer<T> onevent,
      Consumer<String> error) {
    return new RpcCommand("subscribe", event) {
      @Override
      public void onError(String message) {
        error.accept(message);
      }

      @Override
      public void onEvent(RpcMethodResult params) {
        var obj = (T) params;
        onevent.accept(obj);
      }

      @Override
      public String getSubscriber() {
        return event;
      }
    };
  }
}
