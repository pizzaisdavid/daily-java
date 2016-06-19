package com.mycompany.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticsTracker {
  private Map<String, Integer> entries;
  
  public StatisticsTracker() {
    entries = new HashMap<String, Integer>();
  }

  public void compute(ArrayList<String> items) {
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
  
  
}
