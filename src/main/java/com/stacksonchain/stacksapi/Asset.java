package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Asset {

  @JsonProperty("contract_name")
  String contractName;
  @JsonProperty("asset_name")
  String assetName;
  @JsonProperty("contract_address")
  String contractAddress;
}
