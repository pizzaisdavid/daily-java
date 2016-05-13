package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App
{

  public static void main( String[] args )
  {
    System.out.println(getOriginalCoconutCount(5));
  }
  
  public static int getOriginalCoconutCount(int sailorCount) {
    CoconutCount coconutCount = new CoconutCount(sailorCount);
    int startingAmount = 2;
    while (true) {
      coconutCount.set(startingAmount);
      for (int i = 1; i <= sailorCount; i++) {
        coconutCount.payMonkeyTax();
        coconutCount.removeSailorsFairShare();
        if (coconutCount.isWholeNumber()) {
          if (i == sailorCount) {
            return startingAmount;
          }
        } else {
          break;
        }
      }
      startingAmount++;
    }
  }
 
}