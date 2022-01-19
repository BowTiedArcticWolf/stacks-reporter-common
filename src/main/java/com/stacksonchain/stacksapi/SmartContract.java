package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SmartContract {

  @JsonProperty("contract_id")
  String contractId;

  @JsonProperty("source_code")
  String sourceCode;
}
