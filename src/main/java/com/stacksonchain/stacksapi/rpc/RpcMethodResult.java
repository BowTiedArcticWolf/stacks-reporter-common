package com.stacksonchain.stacksapi.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Data;

@Data
@JsonTypeInfo(
    use = Id.NAME,
    include = As.PROPERTY,
    property = "method"
)
@JsonSubTypes({
    @Type(value = BlockMethodResult.class, name = "block"),
    @Type(value = MicroblockMethodResult.class, name = "microblock"),
    @Type(value = MempoolMethodResult.class, name = "mempool")
}) 
public abstract class RpcMethodResult {
  @JsonProperty("jsonrpc")
  String jsonRpc;
}

