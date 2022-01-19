package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostCondition {

  @JsonProperty("type")
  String type;
  @JsonProperty("condition_code")
  String conditionCode;
  @JsonProperty("principal")
  Principal principal;

  @JsonProperty("asset")
  Asset asset;

  @JsonProperty("asset_value")
  AssetValue assetValue;
}
