package com.mycompany.daily;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;


public class StatisticsTrackerTest {
  
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
    StatisticsTracker stats = new StatisticsTracker();
    stats.compute(input);
    assertEquals(3, stats.size());
  }
}
