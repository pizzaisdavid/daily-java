package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void test() {
    assertEquals(3121, App.getOriginalCoconutPile(5));
  }
  
  @Test
  public void calculateFairShare() {
    CoconutPile coconutCount = new CoconutPile(5);
    coconutCount.setTotal(100);
    coconutCount.removeSailorsFairShare();
    assertEquals(80, coconutCount.getTotal(), .001);
  }
  
  @Test
  public void isWholeNumber() {
    CoconutPile coconutCount = new CoconutPile(5);
    coconutCount.setTotal(5);
    assertTrue(coconutCount.isWholeNumber());
    coconutCount.setTotal(5.2);
    assertFalse(coconutCount.isWholeNumber());
  }
}
