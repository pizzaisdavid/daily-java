package com.pizzaisdavid.AllThePlacesYourDogDidntWin;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println(computePlacesYourDogDidntWin(1));
    }
    
    public static ArrayList<String> computePlacesYourDogDidntWin(int placeWon) {
      ArrayList<String> placesNotWon = new ArrayList<String>();
      for (int i = 1; i < 100; i++) {
        if (i != placeWon) {
          placesNotWon.add(formatWithModifier(i));
        }
      }
      return placesNotWon;
    }

    public static String formatWithModifier(int place) {
      String modifier = "";
      if (place % 100 == 11 || place % 100 == 12 || place % 100 == 13) {
        modifier = "th";
      } else {
        modifier = placeModifier(place);
      }
      return place + modifier;
    }

    private static String placeModifier(int place) {
      switch (place % 10) {
      case 1:
        return "st";
      case 2:
        return "nd";
      case 3:
        return "rd";
      default:
        return "th";
      }
    }
}
