package com.pizzaisdavid.PlayingWithTheStockMarket;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {

  @Test
  public void parsePricesValidInput() {
    ArrayList<Double> expected = JunitHelper.arrayList.make(2.0, 3.0, 4.0);
    assertEquals(expected, App.parsePrices("2.0 3.0 4.0"));
  }
  
  @Test
  public void getBestStockTrade() {
    Transaction expected = new Transaction(18.88, 19.03);
    assertTrue(expected.equals(App.getBestStockTrade("19.35 18.88 19.03 18.98")));
  }

}
