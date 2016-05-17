package com.pizzaisdavid.PlayingWithTheStockMarket;

import java.util.ArrayList;

import main.java.com.mycompany.daily.Parser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(getStocks("19.35 19.30 18.88 18.93 18.95 19.03 19.00 18.97 18.97 18.98"));
    }
    
    public static String getStocks(String rawInput) {
      ArrayList<Double> prices = parsePrices(rawInput);
      return "temp";
    }
    
    public static ArrayList<Double> parsePrices(String rawInput) {
      ArrayList<Double> prices = new ArrayList<Double>();
      for (String number: Parser.parse(rawInput, " ")) {
        prices.add(new Double(number));
      }
      return prices;
    }

}
