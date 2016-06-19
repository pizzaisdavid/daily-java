package com.mycompany.daily;

import java.util.ArrayList;

public class StatisticsTracker {
  private Frequency frequency;
  private ArrayList<String> items;
  private int total;

  
  public StatisticsTracker() {
    frequency = new Frequency();
  }

  public void compute(ArrayList<String> items) {
    this.items = items;
    total = items.size();
    setupEntries();
  }

  private void setupEntries() {
    for (String item: items) {
      if (frequency.containsKey(item) == false) {
        frequency.create(item);
      }
      frequency.increment(item);
    }    
  }

  public String toString() {
    String message = "";
    for (Entry each : frequency.values()) {
      message += each.toString(total) + "\n";
    }
    return message;
  }
}
