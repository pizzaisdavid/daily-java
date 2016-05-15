package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoconutPileTest {

  @Test
  public void test() {
    CoconutPile coconutPile = new CoconutPile(5.0);
    assertFalse(coconutPile.isDecimal());
    coconutPile = new CoconutPile(5.5);
    assertTrue(coconutPile.isDecimal());
  }

}
