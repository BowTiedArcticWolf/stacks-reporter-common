package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContractCall {

  @JsonProperty("contract_id")
  String contractId;

  @JsonProperty("function_name")
  String functionName;

  @JsonProperty("function_signature")
  String functionSignature;

  @JsonProperty("function_args")
  List<FunctionArg> functionArgs;
}
