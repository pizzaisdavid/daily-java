package com.pizzaisdavid.JunitHelper;

import java.util.ArrayList;

public class JunitHelper {
  
  public static class arrayList {
  
    public static ArrayList<String> make(String... strings) {
      ArrayList<String> expected = new ArrayList<String>();
      for (String string : strings) {
        expected.add(string);
      }
      return expected;
    }
  }
}
