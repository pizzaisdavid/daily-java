package com.pizzaisdavid.PlayingWithLightSwitches;

public class Range {
  public int upper;
  public int lower;
  
  public Range(int possibleUpper, int possibleLower) {
    upper = possibleUpper;
    lower = possibleLower;
    if (upper < lower) {
      swap();
    }
  }
  
  private void swap() {
    int temp = lower;
    lower = upper;
    upper = temp;
  }
}
