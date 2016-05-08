package com.mycompany.daily;
import main.java.com.mycompany.daily.Parser;
import main.java.com.mycompany.daily.TextFile;
/**
 * mvn compile  
 * mvn exec:java -Dexec.mainClass="com.mycompany.daily.Main"
 */
public class Main {
  
    public static void main( String[] args ) {
      TextFile t = new TextFile("poop");
      
      System.out.println( "Hello World!" );
        
    }
}
