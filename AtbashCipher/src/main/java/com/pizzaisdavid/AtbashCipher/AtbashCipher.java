package com.pizzaisdavid.AtbashCipher;

public class AtbashCipher {
  
  public static String encrypt(String message) {
    char[] letters = message.toCharArray();
    String encryptedMessage = "";
    for (char each : letters) {
      encryptedMessage += encrypt(each);
    }
    return encryptedMessage;
  }
  
  private static char encrypt(char character) {
    char encryptedCharacter = lookupCorrespondingCharacter(character);      
    if (Character.isUpperCase(character)) {
      return Character.toUpperCase(encryptedCharacter);
    }
    return encryptedCharacter;
  }
  
  private static char lookupCorrespondingCharacter(char character) {
    character = Character.toLowerCase(character);
    if (isAlphabetLetter(character)) {
      return atbashCipher(character);
    } else {
      return returnSymbol(character);
    }
  }
  
  private static boolean isAlphabetLetter(char character) {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    return ALPHABET.indexOf(character) != -1;
  }

  private static char atbashCipher(char letter) {
    final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    final String CHIPHER = "zyxwvutsrqponmlkjihgfedcba";
    int position = ALPHABET.indexOf(letter);
    return CHIPHER.charAt(position);
  }
  
  private static char returnSymbol(char character) {
    return character;
  }

}
