package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContractCallTx extends MempoolTx {

  @JsonProperty("contract_call")
  ContractCall contractCall;
}
