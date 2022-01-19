package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AssetValue {

  @JsonProperty("hex")
  String hex;
  @JsonProperty("repr")
  String repr;
}
