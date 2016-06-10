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
    List<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
    int rowLength = getLengthOfLongestRow(input);
    for (ArrayList<String> row : input) {
      matrix = makeColumn(matrix, row, rowLength);
    }
    return matrix; 
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
  
  private static List<ArrayList<String>> makeColumn(List<ArrayList<String>> matrix, ArrayList<String> row, int maxLength) {
    for (int i = 0; i < maxLength; i++) {
      String entry = "";
      try {
        entry = row.get(i);
      } catch (IndexOutOfBoundsException e) {
        entry = " ";
      }
      try {
        ArrayList<String> updatedRow = matrix.get(i);
        updatedRow.add(entry);
        matrix.set(i, updatedRow);
      } catch (Exception e) {
        ArrayList<String> newRow = new ArrayList<String>();
        newRow.add(entry);
        matrix.add(newRow);
      }
    }
    return matrix;
  }
    
    
    
}
