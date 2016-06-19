package com.mycompany.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

import org.junit.runner.RunWith;    
import org.junit.runners.Suite;    
 
@RunWith(Suite.class)    
@Suite.SuiteClasses({    
  CandyBayTest.statisitcs.class,   
  CandyBayTest.count.class   
})

public class CandyBayTest extends TestCase {
  
  public static class statisitcs {

    @Test
    public void small() {
      ArrayList<String> input = new ArrayList<String>(
        Arrays.asList(
          "red",
          "blue",
          "green",
          "green"
        )
      );
      Map<String, Integer> expected = new HashMap<String, Integer>(); 
      expected.put("red", 1);
      expected.put("blue", 1);
      expected.put("green", 2);

      CandyBag bag = new CandyBag(input);
      //assertEquals(expected, bag.statisitcs());
    }
  }
  
  public static class count {

    @Test
    public void small() {
      ArrayList<String> input = new ArrayList<String>(
        Arrays.asList(
          "red",
          "blue",
          "green",
          "green"
        )
      );
      int expected = 4;
      CandyBag bag = new CandyBag(input);
      assertEquals(expected, bag.count());
    }
  }
}
