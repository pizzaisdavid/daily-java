package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void test() {
    assertEquals(3121, App.getCoconutCountFromBeforeGoingToSleep(5));
  }
  
  @Test
  public void calculateFairShare() {
    assertEquals(1.25, App.calculateFairShare(5), .0001);
  }
  
  @Test
  public void isWholeNumber() {
    assertTrue(App.isWholeNumber(5.0));
    assertTrue(App.isWholeNumber(6.0));
    assertFalse(App.isWholeNumber(5.1));
  }


}
