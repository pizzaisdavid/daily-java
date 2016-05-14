package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App
{

  public static void main( String[] args )
  {
    System.out.println(getOriginalCoconutPile(5));
  }
  
  public static int getOriginalCoconutPile(int sailorCount) {
    CoconutPile coconutPile = new CoconutPile(sailorCount);
    int startingAmount = 2;
    while (true) {
      coconutPile.setTotal(startingAmount);
      for (int i = 1; i <= sailorCount; i++) {
        coconutPile = Monkey.takeTax(coconutPile);
        //TODO Sailor.takeFairShare(coconutPile);
        coconutPile.removeSailorsFairShare();
        if (coconutPile.isWholeNumber()) {
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