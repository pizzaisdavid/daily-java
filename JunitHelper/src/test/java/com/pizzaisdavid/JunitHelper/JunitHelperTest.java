package com.pizzaisdavid.JunitHelper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class JunitHelperTest {

  @Test
  public void arrayListOfStrings() {
    ArrayList<String> expected = new ArrayList<String>(Arrays.asList("0.0", "0.1"));
    ArrayList<String> actual = JunitHelper.arrayList.make("0.0", "0.1");
    assertEquals(expected, actual);
  }
  
  @Test
  public void arrayListOfDoubles() {
    ArrayList<Double> expected = new ArrayList<Double>(Arrays.asList(0.0, 0.1));
    ArrayList<Double> actual = JunitHelper.arrayList.make(0.0, 0.1);
    assertEquals(expected, actual);
  }
  
  @Test
  public void arrayListOfArrayListOfStrings() {
    ArrayList<ArrayList<String>> actual = JunitHelper.arrayList.make(
      new String[] {"0.0","0.1"},
      new String[] {"1.0","1.1"}
    );
    assertEquals(new ArrayList<String>(Arrays.asList("0.0", "0.1")), actual.get(0));
    assertEquals(new ArrayList<String>(Arrays.asList("1.0", "1.1")), actual.get(1));
  }
}
