package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class MicroBlock {
    @JsonProperty("canonical")
    boolean canonical;
    @JsonProperty("microblock_canonical")
    boolean microblockCanonical;
    @JsonProperty("microblock_hash")
    String microblockHash;
    @JsonProperty("microblock_sequence")
    int microblockSequence;
    @JsonProperty("microblock_parent_hash")
    String microblockParentHash;
    @JsonProperty("block_height")
    int blockHeight;
    @JsonProperty("parent_block_height")
    int parentBlockHeight;
    @JsonProperty("parent_block_hash")
    String parentBlockHash;
    @JsonProperty("block_hash")
    String blockHash;
    @JsonProperty("txs")
    List<String> txs;
    @JsonProperty("parent_burn_block_height")
    int parentBurnBlockHeight;
    @JsonProperty("parent_burn_block_hash")
    String parentBurnBlockHash;
    @JsonProperty("parent_burn_block_time")
    long parentBurnBlockTime;
    @JsonProperty("parent_burn_block_time_iso")
    String parentBurnBlockTimeIso;
}
