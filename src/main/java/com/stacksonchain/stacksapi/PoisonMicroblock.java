package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PoisonMicroblock {
  @JsonProperty("microblock_header_1")
  String header1;

  @JsonProperty("microblock_header_2")
  String header2;
}
