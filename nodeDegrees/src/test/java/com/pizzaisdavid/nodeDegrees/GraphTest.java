package com.pizzaisdavid.nodeDegrees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class GraphTest {

  @Test
  public void test() {
    Map<String, ArrayList<String>> expected = new HashMap<String, ArrayList<String>>();
    expected.put("1", new ArrayList<String>(Arrays.asList("2", "3")));
    expected.put("2", new ArrayList<String>(Arrays.asList("1")));
    expected.put("3", new ArrayList<String>(Arrays.asList("1")));
    ArrayList<ArrayList<String>> input = new ArrayList<ArrayList<String>>();
    input.add(new ArrayList<String>(Arrays.asList("1", "2")));
    input.add(new ArrayList<String>(Arrays.asList("1", "3")));
    Graph graph = new Graph(input);
    assertEquals(expected, graph.getNodes());
  }

}
