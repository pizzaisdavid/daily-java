package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void test() {
    assertEquals(3121, App.getOriginalCoconutCount(5));
  }
  
  @Test
  public void calculateFairShare() {
    CoconutCount coconutCount = new CoconutCount(5);
    coconutCount.set(100);
    coconutCount.removeSailorsFairShare();
    assertEquals(80, coconutCount.total, .001);
  }
  
  @Test
  public void isWholeNumber() {
    CoconutCount coconutCount = new CoconutCount(5);
    coconutCount.set(5);
    assertTrue(coconutCount.isWholeNumber());
    coconutCount.total = 5.2;
    assertFalse(coconutCount.isWholeNumber());
  }
}
