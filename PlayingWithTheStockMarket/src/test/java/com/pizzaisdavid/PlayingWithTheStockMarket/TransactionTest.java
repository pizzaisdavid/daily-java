package com.pizzaisdavid.PlayingWithTheStockMarket;

import static org.junit.Assert.*;

import org.junit.Test;

public class TransactionTest {

  @Test
  public void profit_Gain() {
    Transaction transaction = new Transaction(2.5, 4.5);
    assertEquals(2.0, transaction.getProfitAsShort(), 0.0001);
  }
  
  @Test
  public void profit_Loss() {
    Transaction transaction = new Transaction(2.5, 0.5);
    assertEquals(-2.0, transaction.getProfitAsShort(), 0.0001);
  }
  
  @Test
  public void equals_DifferentBuyPrices() {
    Transaction transaction1 = new Transaction(20.0, 0.5);
    Transaction transaction2 = new Transaction(2.5, 0.5);
    assertFalse(transaction1.equals(transaction2));
  }
  
  @Test
  public void equals_DifferentSellPrices() {
    Transaction transaction1 = new Transaction(2.0, 20.5);
    Transaction transaction2 = new Transaction(2.0, 0.5);
    assertFalse(transaction1.equals(transaction2));
  }
  
  @Test
  public void equals_DifferentProfits() {
    Transaction transaction1 = new Transaction(2.0, 0.5);
    Transaction transaction2 = new Transaction(2.0, 0.5);
    Price profit = new Price(100.0);
    transaction2.setProfit(profit);
    assertFalse(transaction1.equals(transaction2));
  }


}
