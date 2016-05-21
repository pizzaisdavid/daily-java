package com.pizzaisdavid.nodeDegrees;

import java.util.ArrayList;

public class Graph {
    
  public Nodes nodes_ = new Nodes();
  
  public Graph(ArrayList<ArrayList<String>> edges) {
    for (ArrayList<String> edge: edges) {
      nodes_.addEdge(edge);
    }
  }
  
  public Nodes getNodes() {
    return nodes_;
  }
}