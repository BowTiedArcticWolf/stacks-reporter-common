package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class Tx {

  @JsonProperty("tx_id")
  String txId;

  @JsonProperty("nonce")
  long nonce;

  @JsonProperty("fee_rate")
  String feeRate;

  @JsonProperty("sender_address")
  String senderAddress;

  @JsonProperty("sponsored")
  boolean sponsored;

  @JsonProperty("post_condition_mode")
  String postConditionMode;

  @JsonProperty("post_conditions")
  List<PostCondition> postConditions;

  @JsonProperty("anchor_mode")
  String anchorMode;

  @JsonProperty("is_unanchored")
  boolean isUnanchored;

  @JsonProperty("receipt_time_iso")
  String receiptTimeIso;

  @JsonProperty("block_hash")
  String blockHash;

  @JsonProperty("parent_block_hash")
  String parentBlockHash;

  @JsonProperty("block_height")
  long blockHeight;

  @JsonProperty("burn_block_time")
  long burnBlockTime;

  @JsonProperty("burn_block_time_iso")
  String burnBlockTimeIso;

  @JsonProperty("parent_burn_block_time")
  long parentBurnBlockTime;

  @JsonProperty("parent_burn_block_time_iso")
  String parentBurnBlockTimeIso;

  @JsonProperty("canonical")
  boolean canonical;

  @JsonProperty("tx_index")
  long txIndex;

  @JsonProperty("tx_status")
  String txStatus;

  @JsonProperty("tx_result")
  TxResult txResult;

  @JsonProperty("microblock_hash")
  String microblockHash;

  @JsonProperty("microblock_sequence")
  long microblockSequence;

  @JsonProperty("microblock_canonical")
  boolean microblockCanonical;

  @JsonProperty("event_count")
  int eventCount;

  @JsonProperty("events")
  List<Event> events;

  @JsonProperty("execution_cost_read_count")
  long executionCostReadCount;

  @JsonProperty("execution_cost_read_length")
  int executionCostReadLength;

  @JsonProperty("execution_cost_runtime")
  long executionCostRuntime;

  @JsonProperty("execution_cost_write_count")
  int executionCostWriteCount;

  @JsonProperty("execution_cost_write_length")
  int executionCostWriteLength;

  @JsonProperty("tx_type")
  String txType;

  @JsonProperty("contract_call")
  ContractCall contractCall;
}
