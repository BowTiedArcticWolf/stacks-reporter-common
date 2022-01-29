package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class StxPostCondition extends PostCondition {

  @JsonProperty("principal")
  Principal principal;

  String amount;
}
