package com.pizzaisdavid.AtbashCipher;

import static org.junit.Assert.*;

import org.junit.Test;

public class AtbashCipherTest {

  @Test
  public void initialize() {
    @SuppressWarnings("unused")
    Main main = new Main();
    Main.main(null);
  }
  
  @Test
  public void cipherCharacter() {
    assertEquals("z", AtbashCipher.encrypt("a"));
  }
  
  @Test
  public void preserveCaseCharacter() {
    assertEquals("Z", AtbashCipher.encrypt("A"));
  }
  
  @Test
  public void preserveSymbol() {
    assertEquals("/", AtbashCipher.encrypt("/"));
  }
  
  @Test
  public void cipherString() {
    assertEquals("draziw", AtbashCipher.encrypt("wizard"));
  }
  
  @Test
  public void preserveCaseString() {
    assertEquals("Draziw", AtbashCipher.encrypt("Wizard"));
  }
}
