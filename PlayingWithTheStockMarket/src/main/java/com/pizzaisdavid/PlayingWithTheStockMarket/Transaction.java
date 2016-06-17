package com.pizzaisdavid.PlayingWithTheStockMarket;

public class Transaction {
  private Price buy;
  private Price sell;
  private Price profit;
  
  public Transaction(double buyPrice, double sellPrice) {
    this.buy = new Price(buyPrice);
    this.sell = new Price(sellPrice);
    this.profit = calculateProfit();
  }
  
  public Price calculateProfit() {
    return new Price(sell.doubleValue() - buy.doubleValue());
  }
  
  public String toString() {
    return buy + " " + sell;
  }
  
  public boolean equals(Transaction otherTranscation) {
    return buy.shortValue() == otherTranscation.getBuyPrice().shortValue() &&
        sell.shortValue() == otherTranscation.getSellPrice().shortValue() &&
        getProfitAsShort() == otherTranscation.getProfitAsShort();
  }
  
  public void setProfit(Price profit) {
    this.profit = profit;
  }
  
  public Price getBuyPrice() {
    return buy;
  }
  
  public Price getSellPrice() {
    return sell;
  }
  
  public Price getProfit() {
    return profit;
  }
  
  public short getProfitAsShort() {
    return profit.shortValue();
  }

  public boolean isMoreProfitableThan(Transaction otherTranscation) {
    Price otherProfit = otherTranscation.getProfit();
    return profit.compareTo(otherProfit) == 1;
  }
}
