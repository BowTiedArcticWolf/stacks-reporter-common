package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventAsset {

  @JsonProperty("asset_event_type")
  String assetEventType;
  @JsonProperty("asset_id")
  String assetId;
  @JsonProperty("sender")
  String sender;
  @JsonProperty("recipient")
  String recipient;
  @JsonProperty("value")
  TxResult value;
}
