package com.pizzaisdavid.PlayingWithTheStockMarket;

import java.util.ArrayList;

import main.java.com.mycompany.daily.Parser;

public class StockMarket {
  Transaction highestProfitTrade;

  public StockMarket() {
    highestProfitTrade = new Transaction(0.0, 0.0);
  }
  
  public Transaction getBestStockTrade(String rawInput) {
    ArrayList<Double> prices = parsePrices(rawInput);
    int length = prices.size();
    for (int i = 0; i < length; i++) {
      double buyPrice = prices.get(i);
      for (int k = i; k < length; k++) {
        double sellPrice = prices.get(k);
        Transaction transaction = new Transaction(buyPrice, sellPrice);
        if (transaction.getProfit() > highestProfitTrade.getProfit()) {
          highestProfitTrade = transaction;
        }
      }
    }
    return highestProfitTrade;
  }
  
  public static ArrayList<Double> parsePrices(String rawInput) {
    ArrayList<Double> prices = new ArrayList<Double>();
    for (String each: Parser.parse(rawInput, " ")) {
      prices.add(new Double(each));
    }
    return prices;
  }
}
