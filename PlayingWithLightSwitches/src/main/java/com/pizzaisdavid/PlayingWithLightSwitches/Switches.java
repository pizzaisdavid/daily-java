package com.pizzaisdavid.PlayingWithLightSwitches;

import java.util.ArrayList;

public class Switches extends ArrayList<Boolean> {

  private static final long serialVersionUID = 6324319387231541496L;
  
  public Switches(int length) {
    ArrayList<Boolean> states = new ArrayList<Boolean>();
    for (int i = 0; i < length; i++) {
      states.add(false);
    }
    this.addAll(states);
  }
  
  public void flip(int upper, int lower) {
    if (upper < lower) {
      int temp = lower;
      lower = upper;
      upper = temp;
    }
    for (int i = lower; i <= upper; i++) {
      boolean state = this.get(i);
      this.set(i, swap(state));
    }
  }

  private boolean swap(boolean state) {
    if (state) {
      return false;
    }
    return true;
  }
}
