package BasicGraphStatisticsNodeDegrees.BasicGraphStatisticsNodeDegrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    
  public Map<String, ArrayList<String>> nodes = new HashMap<String, ArrayList<String>>();
  
  public Graph(ArrayList<ArrayList<String>> edges) {
    for (ArrayList<String> edge: edges) {
      addEdge(edge);
    }
  }
  
  private void addEdge(ArrayList<String> edge) {
    String first = edge.get(0);
    String second = edge.get(1);
    addConnection(first, second);
    addConnection(second, first);
  }
  
  private void addConnection(String key, String value) {
    if (this.nodes.containsKey(key) == false) {
      this.nodes.put(key, new ArrayList<String>());
    }
    ArrayList<String> values = this.nodes.get(key);
    values.add(value);
    this.nodes.put(key, values);
  }
}
