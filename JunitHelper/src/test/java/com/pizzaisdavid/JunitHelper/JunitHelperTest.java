package com.pizzaisdavid.JunitHelper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class JunitHelperTest {

  @Test
  public void test() {
    ArrayList<ArrayList<String>> actual = JunitHelper.arrayList.make(
      new String[] {"0.0","0.1"},
      new String[] {"1.0","1.1"}
    );
    assertEquals(new ArrayList<String>(Arrays.asList("0.0", "0.1")), actual.get(0));
    assertEquals(new ArrayList<String>(Arrays.asList("1.0", "1.1")), actual.get(1));
  }
}
