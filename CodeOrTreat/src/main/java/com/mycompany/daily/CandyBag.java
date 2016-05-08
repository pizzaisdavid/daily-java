package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CandyBag {
  
  ArrayList<String> items;
  Map<String, Integer> statisitcs = new HashMap<String, Integer>();

  
  public CandyBag(ArrayList<String> items) {
    this.items = items;
    this.statisitcs = calculateStatistics(this.items);
  }
  
  private Map<String, Integer> calculateStatistics(ArrayList<String> items) {
    Map<String, Integer> statisitcs = new HashMap<String, Integer>();
    for (String item: items) {
      if (statisitcs.containsKey(item) == false) {
        statisitcs.put(item, 0);
      }
      statisitcs.put(item, statisitcs.get(item) + 1);
      //increment()
    }
    return statisitcs;
  }
  
  public Map<String, Integer> statisitcs() {
    return this.statisitcs;
    
  }

  public int count() {
    return this.items.size();
  }
  
  public String toString() {
    int total = count();
    String message = "total: " + total + "\n";
    for (Map.Entry<String, Integer> entry : this.statisitcs.entrySet()) {
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