package com.pizzaisdavid.AtbashCipher;

public class Main 
{
    public static void main( String[] args )
    {
        System.out.println(encrypt("foobar"));  
        System.out.println(encrypt("wizard"));
        System.out.println(encrypt("/r/dailyprogrammer"));
        System.out.println(encrypt("gsrh rh zm vcznkov lu gsv zgyzhs xrksvi"));
    }
    
    public static String encrypt(String message) {
      char[] letters = message.toCharArray();
      String encryptedMessage = "";
      for (char letter : letters) {
        encryptedMessage += encrypt(letter);
      }
      return encryptedMessage;
    }
    
    public static char encrypt(char character) {
      char encryptedCharacter = lookupCorrespondingCharacter(character);      
      if (Character.isUpperCase(character)) {
        return Character.toUpperCase(encryptedCharacter);
      }
      return encryptedCharacter;
    }
    
    private static char lookupCorrespondingCharacter(char character) {
      character = Character.toLowerCase(character);
      try {
        return atbashCipher(character);
      } catch (StringIndexOutOfBoundsException e) {
        return character;
      }
    }
    
    private static char atbashCipher(char letter) {
      final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
      final String CHIPHER = "zyxwvutsrqponmlkjihgfedcba";
      int position = ALPHABET.indexOf(letter);
      return CHIPHER.charAt(position);
    }
}
