package com.pizzaisdavid.PlayingWithTheStockMarket;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class StockMarketTest {

  @Test
  public void parsePricesValidInput() {
    ArrayList<Double> expected = JunitHelper.arrayList.make(2.0, 3.0, 4.0);
    assertEquals(expected, StockMarket.parsePrices("2.0 3.0 4.0"));
  }
  
  @Test
  public void getBestStockTrade() {
    Transaction expected = new Transaction(18.88, 19.03);
    StockMarket market = new StockMarket();
    assertTrue(expected.equals(market.getBestStockTrade("19.35 18.88 19.03 18.98")));
  }
}
