package com.stacksonchain.stacksapi.rpc;

import com.stacksonchain.stacksapi.MicroBlock;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class MicroblockMethodResult extends RpcMethodResult {

  MicroBlock params;
}
