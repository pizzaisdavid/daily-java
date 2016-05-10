package com.pizzaisdavid.nodeDegrees;

import java.util.ArrayList;

public class Graph {
    
  public Nodes nodes = new Nodes();
  
  public Graph(ArrayList<ArrayList<String>> edges) {
    for (ArrayList<String> edge: edges) {
      this.nodes.addEdge(edge);
    }
  }
}