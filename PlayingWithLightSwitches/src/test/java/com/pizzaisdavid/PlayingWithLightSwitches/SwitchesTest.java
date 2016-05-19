package com.pizzaisdavid.PlayingWithLightSwitches;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SwitchesTest {

  @Test
  public void initialize() {
    ArrayList<Boolean> expected = new ArrayList<Boolean>(
      Arrays.asList(
        false,
        false,
        false
      )
    );
    int length = 3;
    Switches switches = new Switches(length);
    assertEquals(expected, switches);
  }
  
  @Test
  public void flipUpperLower() {
    ArrayList<Boolean> expected = new ArrayList<Boolean>(
      Arrays.asList(
        false,
        true,
        true,
        false
      )
    );
    Switches switches = new Switches(4);
    switches.flip(2, 1);
    assertEquals(expected, switches);
  }
  
  @Test
  public void flipLowerUpper() {
    ArrayList<Boolean> expected = new ArrayList<Boolean>(
      Arrays.asList(
        false,
        true,
        true,
        false
      )
    );
    Switches switches = new Switches(4);
    switches.flip(1, 2);
    assertEquals(expected, switches);
  }

}
