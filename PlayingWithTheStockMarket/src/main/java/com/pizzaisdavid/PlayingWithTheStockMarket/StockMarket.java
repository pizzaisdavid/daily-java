package com.pizzaisdavid.PlayingWithTheStockMarket;

import java.util.ArrayList;

import main.java.com.mycompany.daily.Parser;

public class StockMarket {
  public static Transaction getBestStockTrade(String rawInput) {
    ArrayList<Double> prices = parsePrices(rawInput);
    Transaction highestProfit = null;
    int length = prices.size();
    for (int i = 0; i < length; i++) {
      double buyPrice = prices.get(i);
      for (int k = i; k < length; k++) {
        double sellPrice = prices.get(k);
        Transaction transaction = new Transaction(buyPrice, sellPrice);
        if (highestProfit == null || transaction.getProfit() > highestProfit.getProfit()) {
          highestProfit = transaction;
        }
      }
    }
    return highestProfit;
  }
  
  public static ArrayList<Double> parsePrices(String rawInput) {
    ArrayList<Double> prices = new ArrayList<Double>();
    for (String number: Parser.parse(rawInput, " ")) {
      prices.add(new Double(number));
    }
    return prices;
  }
}
