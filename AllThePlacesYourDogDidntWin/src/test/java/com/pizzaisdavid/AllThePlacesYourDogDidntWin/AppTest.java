package com.pizzaisdavid.AllThePlacesYourDogDidntWin;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void formatWithModifier() {
    assertEquals("1st", App.formatWithModifier(1));
    assertEquals("2nd", App.formatWithModifier(2));
    assertEquals("3rd", App.formatWithModifier(3));
    assertEquals("4th", App.formatWithModifier(4));
    
    assertEquals("11th", App.formatWithModifier(11));
    assertEquals("12th", App.formatWithModifier(12));
    assertEquals("13th", App.formatWithModifier(13));
    
    assertEquals("21st", App.formatWithModifier(21));
    assertEquals("22nd", App.formatWithModifier(22));
    assertEquals("23rd", App.formatWithModifier(23));
    
    assertEquals("111th", App.formatWithModifier(111));
    assertEquals("112th", App.formatWithModifier(112));
    assertEquals("113th", App.formatWithModifier(113));
  }
}
