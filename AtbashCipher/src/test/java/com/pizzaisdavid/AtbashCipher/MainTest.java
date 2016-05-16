package com.pizzaisdavid.AtbashCipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

  @Test
  public void initialize() {
    @SuppressWarnings("unused")
    Main main = new Main();
    Main.main(null);
  }
  
  @Test
  public void cipherCharacter() {
    assertEquals('z', Main.encrypt('a'));
  }
  
  @Test
  public void preserveCaseCharacter() {
    assertEquals('Z', Main.encrypt('A'));
  }
  
  @Test
  public void preserveSymbol() {
    assertEquals('/', Main.encrypt('/'));
  }
  
  @Test
  public void cipherString() {
    assertEquals("draziw", Main.encrypt("wizard"));
  }
  
  @Test
  public void preserveCaseString() {
    assertEquals("Draziw", Main.encrypt("Wizard"));
  }
}
