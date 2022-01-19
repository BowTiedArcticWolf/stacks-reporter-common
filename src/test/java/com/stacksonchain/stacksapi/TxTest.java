package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TxTest {

  @Test
  @SneakyThrows
  public void test1() {
    var txs = mapper.readValue(TxTest.class.getResourceAsStream("mempool-txs.json"), MempoolResult.class);
    System.out.println(txs);
    Assertions.assertThat(txs.results)
        .hasSize(txs.limit);
    for (var tx: txs.results) {
      System.out.println(tx);
      Assertions.assertThat(tx.txId).isNotNull();
    }
  }

  private ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

}