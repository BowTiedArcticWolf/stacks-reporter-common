package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TokenTransferTx extends MempoolTx {

  @JsonProperty("token_transfer")
  TokenTransfer tokenTransfer;
}
