package com.mycompany.daily;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class StatisticsTracker extends HashMap<String, Entry>{
  private static final long serialVersionUID = 1L;
  private int total;

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
    com.mycompany.daily.Entry entry = get(item);
    entry.increment();
    put(item, entry);    
  }
  
  public com.mycompany.daily.Entry get(Object key) {
    return super.get(key);
  }
  
  public com.mycompany.daily.Entry put(String key, com.mycompany.daily.Entry value) {
    return super.put(key, value);
  }
  
  public String toString() {
    String message = "";
    for (Entry each : values()) {
      message += each.toString(total) + "\n";
    }
    return message;
  }

  public Collection<com.mycompany.daily.Entry> values() {
    return super.values();
  }
}
