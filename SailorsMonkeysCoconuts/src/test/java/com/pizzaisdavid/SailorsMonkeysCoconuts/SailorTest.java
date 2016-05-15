package com.pizzaisdavid.SailorsMonkeysCoconuts;

import static org.junit.Assert.*;

import org.junit.Test;

public class SailorTest {

  @Test
  public void takeFairShare() {
    CoconutPile coconutPile = new CoconutPile(4); // TODO mock or stub this?
    Sailor sailor = new Sailor(2);
    sailor.takeFairShare(coconutPile);
    assertEquals(2.0, coconutPile.getAmount(), .001);
  }
  
  @Test
  public void getCount() {
    Sailor sailor = new Sailor(2);
    assertEquals(2, sailor.getCount());
  }

}
