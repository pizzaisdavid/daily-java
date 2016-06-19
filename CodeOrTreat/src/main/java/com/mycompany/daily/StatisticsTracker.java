package com.mycompany.daily;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
  
  public void create(String item) {
    put(item, Entry.withName(item));
  }

  public void increment(String item) {
    com.mycompany.daily.Entry entry = get(item);
    entry.increment();
    put(item, entry);    
  }
  
  public String toString() {
    String message = "";
    for (Entry each : values()) {
      message += each.toString(total) + "\n";
    }
    return message;
  }
  
  public int size() {
    return super.size();
  }

  public boolean isEmpty() {
    return super.isEmpty();
  }

  public boolean containsKey(Object key) {
    return super.containsKey(key);
  }

  public boolean containsValue(Object value) {
    return super.containsValue(value);
  }

  public com.mycompany.daily.Entry get(Object key) {
    return super.get(key);
  }

  public com.mycompany.daily.Entry put(String key, com.mycompany.daily.Entry value) {
    return super.put(key, value);
  }

  public com.mycompany.daily.Entry remove(Object key) {
    return super.remove(key);
  }

  public void putAll(Map<? extends String, ? extends com.mycompany.daily.Entry> m) {
    super.putAll(m);
  }

  public void clear() {
    super.clear();
  }

  public Set<String> keySet() {
    return super.keySet();
  }

  public Collection<com.mycompany.daily.Entry> values() {
    return super.values();
  }

  public Set<java.util.Map.Entry<String, com.mycompany.daily.Entry>> entrySet() {
    return super.entrySet();
  }
}
