package com.pizzaisdavid.PlayingWithTheStockMarket;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Price extends BigDecimal {
  private static final long serialVersionUID = 1L;

  public Price(BigInteger val) {
    super(val);
  }

  public Price(double d) {
    super(d);
  }
}
