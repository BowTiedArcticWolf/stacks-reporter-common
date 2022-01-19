package com.stacksonchain.stacksapi;

import java.time.Instant;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BasicTxInfo {

  final String txHash;
  final Instant blockTime;
  final String contractId;
  final String senderAddress;
}
