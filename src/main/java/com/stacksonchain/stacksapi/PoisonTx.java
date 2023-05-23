package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PoisonTx extends MempoolTx {

  @JsonProperty("poison_microblock")
  PoisonMicroblock PoisonMicroblock;
}
