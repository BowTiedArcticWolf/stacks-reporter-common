package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class StacksApiClient {

  @NotNull
  final String apiNode;

  private static final HttpClient client = HttpClient.newHttpClient();

  private ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  public Tx transaction(String hash) {
    return makeRequest(String.format("/extended/v1/tx/%s", hash), Tx.class, apiNode);
  }

  public Info info() {
    return makeRequest("/v2/info", Info.class, apiNode);
  }

  public Info info(String baseUrl) {
    return makeRequest("/v2/info", Info.class, baseUrl);
  }

  @SneakyThrows
  <T> T makeRequest(String path, Class<T> resultClass, String stacksApiUrl) {
    var uri = new URI(stacksApiUrl + path);
    log.debug("fetching from {}", uri);
    var request = HttpRequest.newBuilder()
        .version(Version.HTTP_1_1)
        .uri(uri)
        .build();
    var response = client.send(request, BodyHandlers.ofInputStream());
    return mapper.readValue(response.body(), resultClass);
  }
}
