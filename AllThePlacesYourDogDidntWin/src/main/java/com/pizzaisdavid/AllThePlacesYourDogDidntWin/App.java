package com.pizzaisdavid.AllThePlacesYourDogDidntWin;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(computeThePlacesYourDogDidNotWin(1));
    }
    
    public static ArrayList<String> computeThePlacesYourDogDidNotWin(int placeWon) {
      ArrayList<String> placesNotWon = new ArrayList<String>();
      for (int i = 1; i < 100; i++) {
        if (i != placeWon) {
          placesNotWon.add(formatWithModifier(i));
        }
      }
      return placesNotWon;
    }

    public static String formatWithModifier(int place) {
      String modifier = "th";
      if (place % 100 == 11 || place % 100 == 12 || place % 100 == 13) {
        modifier = "th";
      } else {
        switch (place % 10) {
          case 1:
            modifier = "st";
            break;
          case 2:
            modifier = "nd";
            break;
          case 3:
            modifier = "rd";
            break;
        }
      }
      return place + modifier;
    }
}
