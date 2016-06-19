package com.mycompany.daily;
import main.java.com.mycompany.daily.TextFile;

public class Main {
  
    public static void main( String[] args ) {
      TextFile t = new TextFile("candy.txt");
      CandyBag bag = new CandyBag(t.getLines());
      System.out.println(bag.toString()); 
    }
}
