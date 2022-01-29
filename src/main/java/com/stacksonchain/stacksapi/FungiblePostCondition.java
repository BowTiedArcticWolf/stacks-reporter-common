package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class FungiblePostCondition extends PostCondition {

  String amount;

  @JsonProperty("principal")
  Principal principal;

  @JsonProperty("asset")
  Asset asset;
}
