package com.pizzaisdavid.AtbashCipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void test() {
    assertEquals('z', Main.encrypt('a'));
  }
  
  @Test
  public void preserveCase() {
    assertEquals('Z', Main.encrypt('A'));
  }
  
  @Test
  public void symbol() {
    assertEquals('/', Main.encrypt('/'));
  }
  
  @Test
  public void cipherTest() {
    assertEquals("draziw", Main.encrypt("wizard"));
  }
}
