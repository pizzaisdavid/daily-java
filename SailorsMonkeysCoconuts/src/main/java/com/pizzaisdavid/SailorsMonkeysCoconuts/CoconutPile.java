package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutPile {
  public double total;
  
  public CoconutPile() {
    this.total = 0;
  }
  
  public double getAmount() {
    return this.total;
  }
  
  public void setAmount(int total) {
    this.total = (double) total;
  }
  
  public void setAmount(double total) {
    this.total = total;
  }
  
  public boolean isDecimal() {
    return isWholeNumber() == false;
  }
  
  public  boolean isWholeNumber() {
    return (this.total % 1) == 0;
  }
}
