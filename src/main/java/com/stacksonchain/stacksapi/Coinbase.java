package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class Coinbase {
  @JsonProperty("data")
  String data;

  @JsonProperty("alt_recipient")
  String altRecipient;
}
