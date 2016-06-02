package pizzaisdavid.com.BasicFormatting;

import java.util.ArrayList;

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
    
    public static ArrayList<String> format(ArrayList<String> code) {
      ArrayList<String> formattedCode = new ArrayList<String>();
      int indentLevel = 0;
      for (String line: code) {
        line = stripIndentation(line);
        if (shouldIncreaseIndentLevel(line)) {
          indentLevel++;
        } else if (shouldDecreaseIndentLevel(line)) {
          indentLevel--;
        }
        formattedCode.add(indentLevel + "");
      }
      return formattedCode;
    }
    
    public static String stripIndentation(String line) {
      line.replace("·", "");
      line.replace("»", "");
      return line;
    }
    
    public static boolean shouldIncreaseIndentLevel(String line) {
      ArrayList<String> keywords = make("FOR", "IF");
      String firstWord = parseFirstWord(line);
      return isElementInArray(firstWord, keywords);
      
    }
    
    public static boolean shouldDecreaseIndentLevel(String line) {
      ArrayList<String> keywords = make("NEXT", "ENDIF");
      String firstWord = parseFirstWord(line);
      return isElementInArray(firstWord, keywords);
    }
    
    public static <E> ArrayList<E> make(E...items) {
      ArrayList<E> expected = new ArrayList<E>();
      for (E item: items) {
        expected.add(item);
      }
      return expected;
    }
    
    public static String parseFirstWord(String line) {
      return line.split(" ", 1)[0];
    }
    
    public static boolean isElementInArray(String element, ArrayList<String> sequence) {
      return sequence.contains(element);
    }
}
