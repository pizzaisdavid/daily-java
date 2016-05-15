package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Sailor {

  private double fairShareRatio;
  private int count;

  public Sailor(int sailorCount) {
    final int INDIVIDUAL_PERSON = 1;
    this.count = sailorCount;
    this.fairShareRatio = (double) INDIVIDUAL_PERSON / (double) sailorCount;
  }
  
  public void takeFairShare(CoconutPile coconutPile) {
    double total = coconutPile.getAmount();
    double sailorsFairShare = total * this.fairShareRatio;
    double remainingAmount = total - sailorsFairShare;
    coconutPile.setAmount(remainingAmount);
  }
  
  public int getCount() {
    return this.count;
  }
}
