package com.pizzaisdavid.SailorsMonkeysCoconuts;

public class Monkey {

  public static CoconutPile takeTax(CoconutPile coconutPile) {
    final double AMOUNT_TO_PAY_MONKEY = 1;
    double amountAfterDeduction = coconutPile.getTotal() - AMOUNT_TO_PAY_MONKEY;
    coconutPile.setTotal(amountAfterDeduction);
    return coconutPile;
  }
}
