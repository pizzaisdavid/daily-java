package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonkeyTest {

  @Test
  public void init() {
    @SuppressWarnings("unused")
    Monkey monkey = new Monkey();
  }
  
  @Test
  public void test() {
    CoconutPile coconutPile = new CoconutPile(5.0); // TODO mock or stub this?
    Monkey.takeBribe(coconutPile);
    assertEquals(4.0, coconutPile.getAmount(), .001);
  }

}
