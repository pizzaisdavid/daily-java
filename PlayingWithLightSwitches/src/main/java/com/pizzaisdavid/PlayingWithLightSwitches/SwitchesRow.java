package com.pizzaisdavid.PlayingWithLightSwitches;

import java.util.ArrayList;

public class SwitchesRow extends ArrayList<Boolean> {
  private static final long serialVersionUID = 1L;
  private int length;
  
  public SwitchesRow(int length) {
    for (int i = 0; i < length; i++) {
      add(false);
    }
  }

  public void flipLightsBetween(int upper, int lower) {
    if (upper < lower) {
      int temp = lower;
      lower = upper;
      upper = temp;
    }
    for (int i = lower; i <= upper; i++) {
      boolean s = get(i);
      s = flip(s);
      set(i, s);
    }
  }
  
  public boolean flip(boolean state) {
    return !state;
  }
}
