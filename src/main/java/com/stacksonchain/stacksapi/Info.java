package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Info {

  @JsonProperty("peer_version")
  long peerVersion;
  @JsonProperty("pox_consensus")
  String poxConsensus;
  @JsonProperty("burn_block_height")
  long burnBlockHeight;
  @JsonProperty("stable_pox_consensus")
  String stablePoxConsensus;
  @JsonProperty("stable_burn_block_height")
  long stableBurnBlockHeight;
  @JsonProperty("server_version")
  String serverVersion;
  @JsonProperty("network_id")
  long networkId;
  @JsonProperty("parent_network_id")
  long parentNetworkId;
  @JsonProperty("stacks_tip_height")
  long stacksTipHeight;
  @JsonProperty("stacks_tip")
  String stacksTip;
  @JsonProperty("stacks_tip_consensus_hash")
  String stacksTipConsensusHash;
  @JsonProperty("genesis_chainstate_hash")
  String genesisChainstateHash;
  @JsonProperty("unanchored_tip")
  String unanchoredTip;
  @JsonProperty("unanchored_seq")
  long unanchoredSeq;
}
