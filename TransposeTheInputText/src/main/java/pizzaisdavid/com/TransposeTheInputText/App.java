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
  
  public static Object transpose(List<ArrayList<String>> input) {
    int rowLength = getLengthOfLongestRow(input);
    Matrix matrix = new Matrix(rowLength);
    for (ArrayList<String> row : input) {
      matrix.appendColumn(row);
    }
    return matrix.getContent(); 
  }
  
  private static int getLengthOfLongestRow(List<ArrayList<String>> table) {
    List<Integer> lengths = new ArrayList<Integer>();
    for (ArrayList<String> row : table) {
      lengths.add(row.size());
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
