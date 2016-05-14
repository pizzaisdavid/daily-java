package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutPile {
  public double total;
  private double fairShareRatio;
  
  public CoconutPile(int sailorCount) {
    final int INDIVIDUAL_PERSON = 1;
    this.fairShareRatio = (double) INDIVIDUAL_PERSON / (double) sailorCount;
    this.total = 1;
  }
  
  public double getTotal() {
    return this.total;
  }
  
  public void setTotal(int total) {
    this.total = (double) total;
  }
  
  public void setTotal(double total) {
    this.total = total;
  }
  
  public void removeSailorsFairShare() {
    double sailorsFairShare = this.total * this.fairShareRatio;
    this.total -= sailorsFairShare;
  }
  
  public  boolean isWholeNumber() {
    return (this.total % 1) == 0;
  }
}
