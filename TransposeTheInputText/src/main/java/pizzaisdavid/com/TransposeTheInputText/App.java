package pizzaisdavid.com.TransposeTheInputText;

import java.util.ArrayList;
import java.util.List;

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

    public static Object transpose(List<String> table) {
      List<String> matrix = new ArrayList<String>();
      int newNumberOfRows = getLengthOfLongestRow(table);
      for (int i = 0; i < table.size(); i++) {
        
      }
      return matrix;
    }

    private static int getLengthOfLongestRow(List<String> table) {
      List<Integer> lengths = new ArrayList<Integer>();
      for (String row : table) {
        lengths.add(row.length());
      }
      return max(lengths);
    }

    private static int max(List<Integer> values) {
      int highest = values.get(0);
      for (int value : values) {
        if (value > highest) {
          highest = value;
        }
      }
      return highest;
    }
    
}
