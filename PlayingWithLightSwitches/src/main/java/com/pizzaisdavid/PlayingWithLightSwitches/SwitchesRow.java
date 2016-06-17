package com.pizzaisdavid.PlayingWithLightSwitches;

import java.util.ArrayList;

public class SwitchesRow extends ArrayList<Boolean> {
  private static final long serialVersionUID = 1L;
  private int length;
  
  public SwitchesRow(int length) {
    this.length = length;
    setAllSwitchesToOff();
  }
  
  private void setAllSwitchesToOff() {
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
    flipSwitchesThroughRange(upper, lower);
  }
  
  private void flipSwitchesThroughRange(int upper, int lower) {
    for (int i = lower; i <= upper; i++) {
      boolean lightSwitch = get(i);
      lightSwitch = flip(lightSwitch);
      set(i, lightSwitch);
    }
  }

  public boolean flip(boolean state) {
    return !state;
  }
}
