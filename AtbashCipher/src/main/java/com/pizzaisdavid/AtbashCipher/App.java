package com.pizzaisdavid.AtbashCipher;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static char substitution(char letter) {
      String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
      String CHIPHER = "zyxwvutsrqponmlkjihgfedcba";
      char temp = Character.toLowerCase(letter);
      int position = ALPHABET.indexOf(temp);
      char encode = CHIPHER.charAt(position);
      if (Character.isUpperCase(letter)) {
        return Character.toUpperCase(encode);
      }
      return encode;
    }
}
