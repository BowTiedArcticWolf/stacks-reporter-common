package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class NonFungiblePostCondition extends PostCondition {


  @JsonProperty("principal")
  Principal principal;

  @JsonProperty("asset")
  Asset asset;

  @JsonProperty("asset_value")
  AssetValue assetValue;
}
