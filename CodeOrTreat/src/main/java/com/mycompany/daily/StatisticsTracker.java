package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsTracker {
  private Map<String, Entry> entries;
  private ArrayList<String> items;
  private int total;

  
  public StatisticsTracker() {
    entries = new HashMap<String, Entry>();
  }

  public void compute(ArrayList<String> items) {
    this.items = items;
    total = items.size();
    setupEntries();
  }

  private void setupEntries() {
    for (String item: items) {
      if (entries.containsKey(item) == false) {
        entries.put(item, Entry.withName(item));
      }
      increment(item);
    }    
  }

  private void increment(String item) {
    Entry entry = entries.get(item);
    entry.increment();
    entries.put(item, entry);    
  }
  
  public String toString() {
    String message = "";
    for (Entry each : entries.values()) {
      message += each.toString(total) + "\n";
    }
    return message;
  }
}
