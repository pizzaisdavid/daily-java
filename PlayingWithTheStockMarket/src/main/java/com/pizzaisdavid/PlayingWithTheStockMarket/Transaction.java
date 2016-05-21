package com.pizzaisdavid.PlayingWithTheStockMarket;

public class Transaction {
  private double buyPrice_;
  private double sellPrice_;
  private double profit_;
  
  public Transaction(double buyPrice, double sellPrice) {
    buyPrice_ = buyPrice;
    sellPrice_ = sellPrice;
    profit_ = calculateProfit(buyPrice, sellPrice);
  }
  
  public double calculateProfit(double buyPrice, double sellPrice) {
    return sellPrice - buyPrice;
  }
  
  public String toString() {
    return buyPrice_ + " " + sellPrice_;
  }
  
  public boolean equals(Transaction otherTranscation) {
    return buyPrice_ == otherTranscation.getBuyPrice() &&
        this.sellPrice_ == otherTranscation.getSellPrice() &&
        this.profit_ == otherTranscation.getProfit();
  }
  
  public void setProfit(double profit) {
    profit_ = profit;
  }
  
  public double getBuyPrice() {
    return buyPrice_;
  }
  
  public double getSellPrice() {
    return sellPrice_;
  }
  
  public double getProfit() {
    return profit_;
  }
}
