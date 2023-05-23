package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.util.List;
import lombok.Data;

@Data
@JsonTypeInfo(
    use = Id.NAME,
    include = As.PROPERTY,
    property = "tx_type"
)
@JsonSubTypes({
    @Type(value = ContractCallTx.class, name = "contract_call"),
    @Type(value = TokenTransferTx.class, name = "token_transfer"),
    @Type(value = SmartContractTx.class, name = "smart_contract"),
    @Type(value = CoinbaseTx.class, name = "coinbase"),
    @Type(value = PoisonTx.class, name = "poison_microblock")
})
public abstract class MempoolTx {
  @JsonProperty("tx_id")
  String txId;

  @JsonProperty("nonce")
  long nonce;

  @JsonProperty("tx_status")
  String txStatus;

  @JsonProperty("receipt_time")
  long receiptTime;

  @JsonProperty("receipt_time_iso")
  String receiptTimeIso;

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

  @JsonProperty("tx_type")
  String txType;
}
