package com.mycompany.daily;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StatisticsTracker extends HashMap<String, Entry> {
  private static final long serialVersionUID = 1L;
  private int total;

  public StatisticsTracker(ArrayList<String> items) {
    compute(items);
  }

  public void compute(ArrayList<String> items) {
    total = items.size();
    for (String item: items) {
      if (containsKey(item) == false) {
        create(item);
      }
      increment(item);
    }
  }
  
  public boolean containsKey(Object key) {
    return super.containsKey(key);
  }
  
  public void create(String item) {
    put(item, Entry.withName(item));
  }

  public void increment(String item) {
    Entry entry = get(item);
    entry.increment();
    put(item, entry);    
  }
  
  public Entry get(Object key) {
    return super.get(key);
  }
  
  public Entry put(String key, Entry value) {
    return super.put(key, value);
  }
  
  public String toString() {
    String message = "total: " + total + "\n";
    for (Entry each : values()) {
      message += each.toString(total) + "\n";
    }
    return message;
  }

  public Collection<Entry> values() {
    return super.values();
  }
}
