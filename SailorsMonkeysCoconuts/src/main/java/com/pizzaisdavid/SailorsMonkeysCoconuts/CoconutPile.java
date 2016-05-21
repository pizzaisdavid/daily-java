package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class CoconutPile {
  public double total_;
  
  public CoconutPile(double total) {
    setAmount(total);
  }
  
  public double getAmount() {
    return total_;
  }
  
  public void setAmount(double total) {
    total_ = total;
  }
  
  public boolean hasDecimalValue() {
    return isWholeNumber() == false;
  }
  
  public boolean isWholeNumber() {
    return total_ % 1 == 0;
  }
}
