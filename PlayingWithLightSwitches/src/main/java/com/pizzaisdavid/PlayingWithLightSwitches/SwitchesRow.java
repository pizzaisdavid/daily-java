package com.pizzaisdavid.PlayingWithLightSwitches;

import java.util.ArrayList;

public class SwitchesRow extends ArrayList<Boolean> {
  private static final long serialVersionUID = 1L;
  private int length;
  
  public SwitchesRow(int length) {
    this.length = length;
    initializeAllSwitchesToOff();
  }
  
  private void initializeAllSwitchesToOff() {
    for (int i = 0; i < length; i++) {
      add(false);
    }
  }

  public void flipSwitchesThroughRange(int upper, int lower) {
    Range range = new Range(upper, lower);
    flipSwitches(range);
  }
  
  private void flipSwitches(Range range) {
    for (int i = range.lower; i <= range.upper; i++) {
      boolean lightSwitch = get(i);
      lightSwitch = flip(lightSwitch);
      set(i, lightSwitch);
    }
  }

  public boolean flip(boolean state) {
    return !state;
  }
}
