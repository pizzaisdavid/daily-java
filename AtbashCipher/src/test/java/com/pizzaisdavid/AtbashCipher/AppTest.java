package com.pizzaisdavid.AtbashCipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

  @Test
  public void test() {
    assertEquals('z', App.encrypt('a'));
  }
  
  @Test
  public void preserveCase() {
    assertEquals('Z', App.encrypt('A'));
  }
  
  @Test
  public void symbol() {
    assertEquals('/', App.encrypt('/'));
  }
  
  @Test
  public void cipherTest() {
    assertEquals("draziw", App.encrypt("wizard"));
  }

}
