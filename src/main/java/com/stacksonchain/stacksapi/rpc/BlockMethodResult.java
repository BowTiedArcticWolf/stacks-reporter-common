package com.stacksonchain.stacksapi.rpc;

import com.stacksonchain.stacksapi.Block;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class BlockMethodResult extends RpcMethodResult {

  Block params;
}
