package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class App
{

  public static void main( String[] args )
  {
    System.out.println(getOriginalCoconutPile(5));
  }
  
  public static int getOriginalCoconutPile(int sailorCount) {
    int i = 0;
    while (true) {
      if (isAbleToDivvyUpCoconutPileEvenly(i, sailorCount)) {
        return i;
      }
      i++;
    }
  }
  
  private static boolean isAbleToDivvyUpCoconutPileEvenly(double coconutCount, int sailorCount) {
    CoconutPile pile = new CoconutPile(coconutCount);
    Sailor sailor = new Sailor(sailorCount);
    for (int i = 0; i < sailorCount; i++) {
      pile = Monkey.takeBribe(pile);
      pile = sailor.takeFairShare(pile);
      if (pile.hasDecimalValue()) {
        return false;
      }
    }
    return true;
  }
}