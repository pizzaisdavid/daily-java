package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Sailor {

  private double fairShareRatio;

  public Sailor(int sailorCount) {
    final int INDIVIDUAL_PERSON = 1;
    this.fairShareRatio = (double) INDIVIDUAL_PERSON / (double) sailorCount;
  }
  
  public CoconutPile takeFairShare(CoconutPile coconutPile) {
    double total = coconutPile.getTotal();
    double sailorsFairShare = total * this.fairShareRatio;
    double remainingAmount = total - sailorsFairShare;
    coconutPile.setTotal(remainingAmount);
    return coconutPile;
  }

}
