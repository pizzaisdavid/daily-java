package com.pizzaisdavid.PlayingWithLightSwitches;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SwitchesRowTest {

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
    SwitchesRow switches = new SwitchesRow(length);
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
    SwitchesRow switches = new SwitchesRow(4);
    switches.flipLightsBetween(2, 1);
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
    SwitchesRow switches = new SwitchesRow(4);
    switches.flipLightsBetween(1, 2);
    assertEquals(expected, switches);
  }

}
