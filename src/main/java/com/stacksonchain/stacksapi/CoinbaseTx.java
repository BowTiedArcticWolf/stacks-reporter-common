package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class CoinbaseTx extends MempoolTx {

  @JsonProperty("coinbase_payload")
  Coinbase coinbase;

}