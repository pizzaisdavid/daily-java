package com.pizzaisdavid.nodeDegrees;

import java.util.ArrayList;
import java.util.HashMap;


public class Nodes extends HashMap<String, ArrayList<String>> {

  private static final long serialVersionUID = 7881267917720527545L;
  
  public Nodes() {
  }
  
  public void addEdge(ArrayList<String> edge) {
    String first = edge.get(0);
    String second = edge.get(1);
    addConnection(first, second);
    addConnection(second, first);
  }
  
  private void addConnection(String key, String value) {
    if (this.containsKey(key) == false) {
      this.put(key, new ArrayList<String>());
    }
    ArrayList<String> values = this.get(key);
    values.add(value);
    this.put(key, values);
  }
}