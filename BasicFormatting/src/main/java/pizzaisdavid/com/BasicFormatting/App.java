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
          formattedCode.add(indentCode(indentLevel, line));
          indentLevel++;
        } else if (shouldDecreaseIndentLevel(line)) {
          indentLevel--;
          formattedCode.add(indentCode(indentLevel, line));
        } else {
          formattedCode.add(indentCode(indentLevel, line));
        }
      }
      return formattedCode;
    }
    
    public static String stripIndentation(String line) {
      line = line.replace("·", "");
      line = line.replace("»", "");
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
      int THERE_ISNT_A_SPACE = -1;
      int firstSpace = line.indexOf(' ');
      if (firstSpace == THERE_ISNT_A_SPACE) {
        return line;
      }
      return line.substring(0, firstSpace);
    }
    
    public static boolean isElementInArray(String element, ArrayList<String> sequence) {
      return sequence.contains(element);
    }
    
    public static String indentCode(int indentLevel, String line) {
      String TAB_SPACING = "····";
      String indentation = "";
      for (int i = 0; i < indentLevel; i++) {
        indentation +=  TAB_SPACING;
      }
      return indentation + line;
    }
}
