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
  
  public static boolean isAbleToDivvyUpCoconutPileEvenly(double coconutCount, int sailorCount) {
    CoconutPile pile = new CoconutPile();
    Sailor sailor = new Sailor(sailorCount);
    for (int i = 0; i < sailorCount; i++) {
      Monkey.takeBribe(pile);
      sailor.takeFairShare(pile);
      if (pile.isDecimal()) {
        return false;
      }
    }
    return true;
  }
}