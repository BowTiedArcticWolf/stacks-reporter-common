package com.stacksonchain.stacksapi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class TxTest {

  @Test
  @SneakyThrows
  public void test1() {
    var txs = mapper.readValue(TxTest.class.getResourceAsStream("mempool-txs.json"), MempoolResult.class);
    Assertions.assertThat(txs.results)
        .hasSize(txs.limit);

    Map<String, MempoolTx> pool = new HashMap<>();
    for (var tx: txs.results) {
      Assertions.assertThat(tx.txId).isNotNull();
      pool.put(tx.txId, tx);
    }

    Assertions.assertThat(pool.containsKey("0xd9deb293d241f9f976b2da8ccbdab18d91620882e39194c4cf9b022b2b5ce392"))
        .isTrue();
    var postConditions = pool.get("0xd9deb293d241f9f976b2da8ccbdab18d91620882e39194c4cf9b022b2b5ce392")
        .postConditions;
    Assertions.assertThat(postConditions).hasSize(1);
    Assertions.assertThat(((StxPostCondition)postConditions.get(0)).amount)
        .isEqualTo("2000000");

    var fungible = pool.get("0x4f0f0446f3040b17852d5ee1b171471583cf2a3c19cb92a1a82ef6c883358d03")
        .postConditions;
    Assertions.assertThat(fungible.get(0) instanceof FungiblePostCondition)
        .isTrue();
    System.out.println(fungible.get(0));
    var fcond = (FungiblePostCondition) fungible.get(0);
    Assertions.assertThat(fcond.amount)
        .isEqualTo("17411143");
    Assertions.assertThat(fcond.asset.assetName)
        .isEqualTo("miamicoin");


  }

  private ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

}