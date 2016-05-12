package com.pizzaisdavid.AtbashCipher;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static String encrypt(String message) {
      char[] letters = message.toCharArray();
      String encryptedMessage = "";
      for (char letter : letters) {
        encryptedMessage += encrypt(letter);
      }
      return encryptedMessage;
    }
    
    public static char encrypt(char letter) {
      char encryptedLetter = lookupCorrespondingCharacter(letter);      
      if (Character.isUpperCase(letter)) {
        return Character.toUpperCase(encryptedLetter);
      }
      return encryptedLetter;
    }
    
    private static char lookupCorrespondingCharacter(char letter) {
      String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
      String CHIPHER = "zyxwvutsrqponmlkjihgfedcba";
      letter = Character.toLowerCase(letter);
      int position = ALPHABET.indexOf(letter);
      return CHIPHER.charAt(position);
    }
}
