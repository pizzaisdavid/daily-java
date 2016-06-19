package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsTracker {
  private Map<String, Integer> entries;
  private ArrayList<String> items;
  private int total;

  
  public StatisticsTracker() {
    entries = new HashMap<String, Integer>();
  }

  public void compute(ArrayList<String> items) {
    this.items = items;
    this.total = items.size();
    for (String item: items) {
      if (entries.containsKey(item) == false) {
        entries.put(item, 0);
      }
      entries.put(item, entries.get(item) + 1);
      //increment()
    }
  }

  public Map<String, Integer> getEntries() {
    return entries;
  }
  
  public String toString() {
    String message = "";
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
