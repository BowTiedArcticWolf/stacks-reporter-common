package com.stacksonchain.stacksapi;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Block {

  @JsonProperty("canonical")
  String canonical;

  @JsonProperty("height")
  int height;

  @JsonProperty("hash")
  String hash;

  @JsonProperty("parent_block_hash")
  String parentBlockHash;

  @JsonProperty("burn_block_time")
  String burnBlockTime;

  @JsonProperty("burn_block_time_iso")
  String burnBlockTimeIso;

  @JsonProperty("burn_block_hash")
  String burnBlockHash;

  @JsonProperty("burn_block_height")
  String burnBlockHeight;

  @JsonProperty("miner_txid")
  String minerTxid;

  @JsonProperty("parent_microblock_hash")
  String parentMicroblockHash;

  @JsonProperty("parent_microblock_sequence")
  String parentMicroblockSequence;

  @JsonProperty("txs")
  List<String> txs;

  @JsonProperty("microblocks_accepted")
  List<String> microblocksAccepted;
}
