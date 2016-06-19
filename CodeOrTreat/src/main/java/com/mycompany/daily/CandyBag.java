package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CandyBag {
  
  ArrayList<String> items;
  StatisticsTracker statistics = new StatisticsTracker();
  
  public CandyBag(ArrayList<String> items) {
    this.items = items;
    statistics.compute(items);
  }
  
  public String toString() {
    Map<String, Integer> entries = statistics.getEntries();
    for (Map.Entry<String, Integer> entry : entries.entrySet()) {
      message += entryToString(entry, total) + "\n";
    }
    return message;
  }
  
  private String entryToString(Map.Entry<String, Integer> entry, int total) {
    String name = entry.getKey();
    int candyCount = entry.getValue();
    double precentage = percent(candyCount, total);
    return String.format("name: %s, count: %d, precent: %f", name, candyCount, precentage);
  }
  
  private double percent(int amount, int total) {
    return (double) amount / (double) total;
  }
}
