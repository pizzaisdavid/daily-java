package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CandyBag {
  
  ArrayList<String> items;
  StatisticsTracker statisitcs = new StatisticsTracker();
  
  public CandyBag(ArrayList<String> items) {
    this.items = items;
    statisitcs.compute(items);
  }
  
  public int count() {
    return items.size();
  }
  
  public String toString() {
    int total = count();
    String message = "total: " + total + "\n";
    Map<String, Integer> entries = statisitcs.getEntries();
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
