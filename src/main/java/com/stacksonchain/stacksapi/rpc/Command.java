package com.stacksonchain.stacksapi.rpc;

import com.fasterxml.jackson.databind.JsonNode;

public interface Command {

  String getMethod();

  String getSubscriber();

  JsonNode getParams();

  void onError(String message);

  void onEvent(RpcMethodResult params);
}
