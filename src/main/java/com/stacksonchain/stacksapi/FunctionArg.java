package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FunctionArg {

  @JsonProperty("hex")
  String hex;
  @JsonProperty("repr")
  String repr;
  @JsonProperty("name")
  String name;
  @JsonProperty("type")
  String type;
}
