package com.stacksonchain.stacksapi;

import lombok.Data;

@Data
public class MempoolResult {

  int limit;
  int offset;
  int total;
  MempoolTx[] results;

}
