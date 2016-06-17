package com.pizzaisdavid.JunitHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class JunitHelper {
  
  public static class arrayList {
  
    public static <E> ArrayList<E> make(E...items) {
      ArrayList<E> output = new ArrayList<E>();
      for (E each : items) {
        output.add(each);
      }
      return output;
    }
    
    public static ArrayList<ArrayList<String>> make(String[]... lists) {
      ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
      for (String[] each : lists) {
        output.add(new ArrayList<String>(Arrays.asList(each)));
      }
      return output;
    }
  }
}
