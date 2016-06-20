package com.mycompany.daily;
import java.util.ArrayList;

import main.java.com.mycompany.daily.TextFile;

public class Main {
  
    public static void main( String[] args ) {
      TextFile t = new TextFile("candy.txt");
      ArrayList<String> candies = t.getLines();
      StatisticsTracker bag = new StatisticsTracker();
      bag.compute(candies);
      System.out.println(bag); 
    }
}
