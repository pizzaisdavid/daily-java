package com.pizzaisdavid.AllThePlacesYourDogDidntWin;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(computeThePlacesYourDogDidNotWin(1));
    }
    
    public static ArrayList<String> computeThePlacesYourDogDidNotWin(int place) {
      ArrayList<String> placesNotWon = new ArrayList<String>();
      for (int i = 1; i < 100; i++) {
        if (i == place) {
          // do nothing
        } else {
          placesNotWon.add(formatWithModifier(i));
        }
      }
      return placesNotWon;
    }

    private static String formatWithModifier(int place) {
      String modifier = "th";
      if (place % 100 == 11 || place % 100 == 12 || place % 100 == 13) {
        modifier = "th";
      } else if (place % 10 == 1) {
        modifier = "st";
      } else if (place % 10 == 2) {
        modifier = "nd";
      } else if (place % 10 == 3) {
        modifier = "rd";
      }
      return place + modifier;
    }
}
