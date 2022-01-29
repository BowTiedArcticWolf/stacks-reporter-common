package com.stacksonchain.stacksapi;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class MicroBlockTest {

  @Test
  @SneakyThrows
  public void deserialize() {
    var mapper= new ObjectMapper();
    var text = mapper.readValue(MicroBlockTest.class.getResourceAsStream("mblock.js"), MicroBlock.class);
    Assertions.assertThat(text.microblockHash).isEqualTo("0x6d02b7c161ed0a0e08f634f9f371169219903c67da171a02983081d9b8686e76");
  }
}