package com.pizzaisdavid.PlayingWithTheStockMarket;

public class App 
{
  public static void main( String[] args )
  {
    String input = "19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98";
    Transaction transaction = StockMarket.getBestStockTrade(input);
    System.out.println(transaction);
  }
}


