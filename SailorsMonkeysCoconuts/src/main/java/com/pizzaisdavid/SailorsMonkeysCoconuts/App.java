package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App
{

  public static void main( String[] args )
  {
    System.out.println(getOriginalCoconutPile(5));
  }
  
  public static int getOriginalCoconutPile(int sailorCount) {
    CoconutPile coconutPile = new CoconutPile();
    Sailor sailor = new Sailor(sailorCount);
    int startingAmount = 2;
    while (true) {
      coconutPile.setTotal(startingAmount);
      for (int i = 1; i <= sailorCount; i++) {
        Monkey.takeTax(coconutPile); // TODO pass by reference?
        sailor.takeFairShare(coconutPile); // TODO pass by reference?
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