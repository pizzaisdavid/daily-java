package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Sailor {
  private int count;
  private double fairShareRatio;
  
  public Sailor(int sailorCount) {
    final int INDIVIDUAL_PERSON = 1;
    this.count = sailorCount;
    this.fairShareRatio = (double) INDIVIDUAL_PERSON / (double) sailorCount;
  }
  
  public int getCount() {
    return this.count;
  }

  public void takeFairShare(CoconutPile coconutPile) {
    double total = coconutPile.getAmount();
    double sailorsFairShare = total * fairShareRatio;
    double remaining = total - sailorsFairShare;
    coconutPile.setAmount(remaining);
  }
}
