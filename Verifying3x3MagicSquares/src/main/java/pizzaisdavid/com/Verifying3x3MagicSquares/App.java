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
      return areRowsMagic(square) && areColumnsMagic(square) && areDiagonalsMagic(square);
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
    
    public static boolean areDiagonalsMagic(List<Integer> square) {
      return isUpperLeftToLowerRightDiagonalMagic(square) && isUpperRightToLowerLeftDiagonalMagic(square);
    }
    
    public static boolean isUpperLeftToLowerRightDiagonalMagic(List<Integer> square) {
      List<Integer> diagonal = getUpperLeftToLowerRightDiagonal(square);
      return isMagicList(diagonal);
    }
    
    public static boolean isUpperRightToLowerLeftDiagonalMagic(List<Integer> square) {
      List<Integer> diagonal = getUpperRightToLowerLeftDiagonal(square);
      return isMagicList(diagonal);
    }
    
    public static List<Integer> getUpperLeftToLowerRightDiagonal(List<Integer> square) {
      int DIAGONAL_FACTOR = 1;
      List<Integer> diagonal = new ArrayList<Integer>();
      int length = computeDimensionLength(square);
      for (int i = 0; i < square.size(); i = i + length + DIAGONAL_FACTOR) {
        int cell = square.get(i);
        diagonal.add(cell);
      }
      return diagonal;
    }
    
    public static List<Integer> getUpperRightToLowerLeftDiagonal(List<Integer> square) {
      int DIAGONAL_FACTOR = -1;
      List<Integer> diagonal = new ArrayList<Integer>();
      int length = computeDimensionLength(square);
      for (int i = length + DIAGONAL_FACTOR; i < square.size(); i = i + length + DIAGONAL_FACTOR) {
        int cell = square.get(i);
        diagonal.add(cell);
      }
      diagonal.remove(diagonal.size() - 1);
      return diagonal;
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
