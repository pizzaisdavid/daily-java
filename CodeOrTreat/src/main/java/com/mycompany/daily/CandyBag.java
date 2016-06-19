package com.mycompany.daily;

import java.util.ArrayList;

public class CandyBag {
  ArrayList<String> items;
  StatisticsTracker statistics = new StatisticsTracker();
  
  public CandyBag(ArrayList<String> items) {
    this.items = items;
    statistics.compute(items);
  }
  
  public String toString() {
    return "total: " + items.size() + "\n"
        + statistics.toString();
  }
}
