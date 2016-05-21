package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Sailor {
  private int count_;
  private double fairShareRatio_;
  
  public Sailor(int count) {
    final int INDIVIDUAL_PERSON = 1;
    count_ = count;
    fairShareRatio_ = (double) INDIVIDUAL_PERSON / (double) count;
  }
  
  public int getCount() {
    return count_;
  }

  public void takeFairShare(CoconutPile coconutPile) {
    double total = coconutPile.getAmount();
    double sailorsFairShare = total * fairShareRatio_;
    double remaining = total - sailorsFairShare;
    coconutPile.setAmount(remaining);
  }
}
