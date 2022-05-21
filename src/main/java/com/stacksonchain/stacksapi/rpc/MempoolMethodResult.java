package com.stacksonchain.stacksapi.rpc;

import com.stacksonchain.stacksapi.MempoolTx;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class MempoolMethodResult extends RpcMethodResult {

  MempoolTx params;
}
