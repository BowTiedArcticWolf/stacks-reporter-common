package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class SmartContractTx extends MempoolTx {

  @JsonProperty("smart_contract")
  SmartContract smartContract;

}
