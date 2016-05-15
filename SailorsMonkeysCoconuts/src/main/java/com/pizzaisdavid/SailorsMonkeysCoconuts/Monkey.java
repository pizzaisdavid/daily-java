package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Monkey {

  public static void takeBribe(CoconutPile coconutPile) {
    final double AMOUNT_TO_PAY_MONKEY = 1;
    double total = coconutPile.getAmount();
    double remainingAmount = total - AMOUNT_TO_PAY_MONKEY;
    coconutPile.setAmount(remainingAmount);
  }
}
