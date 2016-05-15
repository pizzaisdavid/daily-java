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
    int i = 0;
    while (true) {
      coconutPile.setAmount(i);
      if (isAbleToDivvyUpCoconutPileEvenly(coconutPile, sailor)){
        return i;
      }
      i++;
    }
  }
  
  public static boolean isAbleToDivvyUpCoconutPileEvenly(CoconutPile coconutPile, Sailor sailor) {
    int sailorCount = sailor.getCount();
    for (int i = 1; i <= sailorCount; i++) {
      Monkey.takeBribe(coconutPile);
      sailor.takeFairShare(coconutPile);
      if (coconutPile.isDecimal()) {
        return false;
      }
    }
    return true;
  }
}