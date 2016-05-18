package com.pizzaisdavid.JunitHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class JunitHelper {
  
  public static class arrayList {
  
    public static <E> ArrayList<E> make(E...items) {
      ArrayList<E> expected = new ArrayList<E>();
      for (E item: items) {
        expected.add(item);
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
