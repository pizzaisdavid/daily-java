package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutCount {
  public double total;
  private double fairShareRatio;
  
  public CoconutCount(int sailorCount) {
    final int INDIVIDUAL_PERSON = 1;
    this.fairShareRatio = (double) INDIVIDUAL_PERSON / (double) sailorCount;
    this.total = 1;
  }
  
  public void set(int startingAmount) {
    this.total = (double) startingAmount;
  }
  
  public void payMonkeyTax() {
    final double AMOUNT_TO_PAY_MONKEY = 1;
    this.total -= AMOUNT_TO_PAY_MONKEY;
  }
  
  public void removeSailorsFairShare() {
    double sailorsFairShare = this.total * this.fairShareRatio;
    this.total -= sailorsFairShare;
  }
  
  public  boolean isWholeNumber() {
    return (this.total % 1) == 0;
  }
}
