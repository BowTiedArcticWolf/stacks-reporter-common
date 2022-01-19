package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Principal {

  @JsonProperty("type_id")
  String typeId;
  @JsonProperty("address")
  String address;
}
