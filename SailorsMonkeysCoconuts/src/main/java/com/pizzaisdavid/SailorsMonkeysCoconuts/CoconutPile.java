package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutPile {
  public double total;
  
  public CoconutPile(double total) {
    setAmount(total);
  }
  
  public double getAmount() {
    return this.total;
  }
  
  public void setAmount(double total) {
    this.total = total;
  }
  
  public  boolean isDecimal() {
    return this.total % 1 != 0;
  }
}
