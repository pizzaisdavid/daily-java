package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Monkey {

  public static CoconutPile takeBribe(CoconutPile coconutPile) {
    final double AMOUNT_TO_PAY_MONKEY = 1;
    double total = coconutPile.getAmount();
    double remaining = total - AMOUNT_TO_PAY_MONKEY;
    coconutPile.setAmount(remaining);
    return coconutPile;
  }
}
