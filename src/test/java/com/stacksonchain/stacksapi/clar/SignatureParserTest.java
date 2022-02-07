package com.stacksonchain.stacksapi.clar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SignatureParserTest {

  @Test
  public void parse1() {
    var parser = new SignatureParser();
    Assertions.assertThat(
            parser.parse(
                "(define-public (purchase-asset (tradables trait_reference) (tradable-id uint)))"))
        .isEqualTo(new Signature("purchase-asset", List.of("tradables", "tradable-id")));
    Assertions.assertThat(
            parser.parse(
                "(define-public (mint ))"))
        .isEqualTo(new Signature("mint", List.of()));
  }
}