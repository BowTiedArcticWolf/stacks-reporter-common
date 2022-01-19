package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Event {

  @JsonProperty("event_index")
  String eventIndex;
  @JsonProperty("event_type")
  String eventType;
  @JsonProperty("tx_id")
  String txId;
  @JsonProperty("asset")
  EventAsset asset;

}
