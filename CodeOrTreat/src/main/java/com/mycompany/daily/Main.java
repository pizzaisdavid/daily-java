package com.mycompany.daily;
import java.util.ArrayList;

import main.java.com.mycompany.daily.TextFile;

public class Main {
  
    public static void main( String[] args ) {
      TextFile file = new TextFile("candy.txt");
      ArrayList<String> candies = file.getLines();
      StatisticsTracker bag = new StatisticsTracker(candies);
      bag.compute(candies);
      System.out.println(bag); 
    }
}
