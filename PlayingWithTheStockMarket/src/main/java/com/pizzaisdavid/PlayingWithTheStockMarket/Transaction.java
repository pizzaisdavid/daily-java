package com.pizzaisdavid.PlayingWithTheStockMarket;

public class Transaction {
  public double buyPrice;
  public double sellPrice;
  public double profit;
  
  public Transaction(double buyPrice, double sellPrice) {
    this.buyPrice = buyPrice;
    this.sellPrice = sellPrice;
    this.profit = calculateProfit(buyPrice, sellPrice);
  }
  
  public double calculateProfit(double buyPrice, double sellPrice) {
    return sellPrice - buyPrice;
  }
  
  public String toString() {
    return this.buyPrice + " " + this.sellPrice;
  }
  
  public boolean equals(Transaction otherTranscation) {
    return this.buyPrice == otherTranscation.buyPrice &&
        this.sellPrice == otherTranscation.sellPrice &&
        this.profit == otherTranscation.profit;
  }
}
