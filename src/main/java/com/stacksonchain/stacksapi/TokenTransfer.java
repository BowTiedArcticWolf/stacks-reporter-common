package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TokenTransfer {
  @JsonProperty("recipient_address")
  String recipientAddress;

  String amount;

  String memo;

}
