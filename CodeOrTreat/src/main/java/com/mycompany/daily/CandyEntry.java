package com.mycompany.daily;

public class CandyEntry {
  private int count;
  private String name;
  
  public CandyEntry() {
    count = 1;
  }
  
  public CandyEntry(String name) {
    this.name = name;
  }

  public static CandyEntry withName(String name) {
    return new CandyEntry(name);
  }

  public void increment() {
    count++;
  }
  
  public String toString(int total) {
    double precentage = percent(count, total);
    return String.format("name: %s, count: %d, precent: %f", name, count, precentage);
  }
  
  private double percent(int amount, int total) {
    return (double) amount / (double) total;
  }
  
}
