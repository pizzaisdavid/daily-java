package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutPile {
  public double total;
  
  public CoconutPile() {
    this.total = 0;
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
  
  public  boolean isWholeNumber() {
    return (this.total % 1) == 0;
  }
}
