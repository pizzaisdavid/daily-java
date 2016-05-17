package com.pizzaisdavid.JunitHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class JunitHelper {
  
  public static class arrayList {
  
    public static ArrayList<String> make(String... strings) {
      ArrayList<String> expected = new ArrayList<String>();
      for (String string : strings) {
        expected.add(string);
      }
      return expected;
    }
    
    public static ArrayList<Double> make(Double... numbers) {
      ArrayList<Double> expected = new ArrayList<Double>();
      for (Double number : numbers) {
        expected.add(number);
      }
      return expected;
    }
    
    public static ArrayList<ArrayList<String>> make(String[]... lists) {
      ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
      for (String[] list : lists) {
        expected.add(new ArrayList<String>(Arrays.asList(list)));
      }
      return expected;
    }
  }
}
