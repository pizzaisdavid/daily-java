package com.mycompany.daily;

public class Entry {
  private int count;
  private String name;
  
  public Entry() {
    count = 1;
  }
  
  public Entry(String name) {
    this.name = name;
  }

  public static Entry withName(String name) {
    return new Entry(name);
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
