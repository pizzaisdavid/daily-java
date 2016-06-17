package com.pizzaisdavid.PlayingWithLightSwitches;

import java.util.ArrayList;
import main.java.com.mycompany.daily.Parser;
import main.java.com.mycompany.daily.TextFile;


public class Main {
  
  public static void main(String[] args) {
    TextFile file = new TextFile("switches.txt");
    ArrayList<ArrayList<String>> content = Parser.parse(file.getLines(), " ");
    int length = Integer.parseInt(content.remove(0).get(0));
    SwitchesRow switches = new SwitchesRow(length);
    for (ArrayList<String> range : content) {
      int number1 = Integer.parseInt(range.get(0));
      int number2 = Integer.parseInt(range.get(1));
      switches.flip(number1, number2);
    }
  }
}
