package com.stacksonchain.stacksapi;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class BlockTest {

  @Test
  @SneakyThrows
  public void deser() {
    var mapper = new ObjectMapper()
        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    var block = mapper.readValue(BlockTest.class.getResourceAsStream("block.json"), Block.class);
    Assertions.assertThat(block.getHeight())
        .isEqualTo(46102);
  }

}