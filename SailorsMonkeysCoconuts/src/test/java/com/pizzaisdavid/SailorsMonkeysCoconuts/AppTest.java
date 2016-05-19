package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void initialize() {
    @SuppressWarnings("unused")
    App app = new App();
    App.main(null);
  }
  
  @Test
  public void test() {
    assertEquals(3121, App.getOriginalCoconutPile(5));
  }
}
