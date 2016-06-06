package pizzaisdavid.com.Verifying3x3MagicSquares;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    public static boolean isMagicSquare(List<Integer> square) {
      return false;
    }
    
    public static boolean areRowsMagic(List<Integer> square) {
      int LENGTH = 3;
      for (int i = 0; i < square.size(); i = i + LENGTH) {
        List<Integer> row = getRow(square, i);
        if (isMagicList(row) == false) {
          return false;
        }
      }
      return true;
    }
    
    public static List<Integer> getRow(List<Integer> square, int startingIndex) {
      int length = computeDimensionLength(square);
      return square.subList(startingIndex, startingIndex + length);
    }
    
    public static int computeDimensionLength(List<Integer> square) {
      return (int) Math.sqrt(square.size());
    }
    
    public static boolean areColumnsMagic(List<Integer> square) {
      int LENGTH = 3;
      for (int i = 0; i < LENGTH; i++) {
        List<Integer> column = getColumn(square, i);
        if (isMagicList(column) == false) {
          return false;
        }
      }
      return true;
    }
    
    public static List<Integer> getColumn(List<Integer> square, int startingIndex) {
      List<Integer> column = new ArrayList<Integer>();
      int length = computeDimensionLength(square);
      for (int i = startingIndex; i < square.size(); i = i + length) {
        int cell = square.get(i);
        column.add(cell);
      }
      return column;
    }
    
    public static boolean isMagicList(List<Integer> list) {
      int MAGIC_NUMBER = 15;
      int total = 0;
      for (int i = 0; i < list.size(); i++) {
        total += list.get(i);
      }
      return total == MAGIC_NUMBER;
    }
}
