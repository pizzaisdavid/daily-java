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
    return buyPrice_ + " " + sellPrice_;
  }
  
  public boolean equals(Transaction otherTranscation) {
    return buy.shortValue() == otherTranscation.getBuyPrice().shortValue() &&
        sell.shortValue() == otherTranscation.getSellPrice().shortValue() &&
        getProfitAsShort() == otherTranscation.getProfitAsShort();
  }
  
  public void setProfit(double profit) {
    profit_ = profit;
  }
  
    return buyPrice_;
  public Price getBuyPrice() {
  }
  
    return sellPrice_;
  public Price getSellPrice() {
  }
  
    return profit_;
  public Price getProfit() {
  }
  
  public short getProfitAsShort() {
    return profit.shortValue();
  }

  public boolean isMoreProfitableThan(Transaction otherTranscation) {
    Price otherProfit = otherTranscation.getProfit();
    return profit.compareTo(otherProfit) == 1;
  }
}
