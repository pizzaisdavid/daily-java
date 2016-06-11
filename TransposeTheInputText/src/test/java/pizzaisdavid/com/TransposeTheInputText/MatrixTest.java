package pizzaisdavid.com.TransposeTheInputText;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class MatrixTest {

  @Test
  public void transpose_SameLength() {
    ArrayList<ArrayList<String>> input = JunitHelper.arrayList.make(
      new String[] {"A", "B", "C"},
      new String[] {"D", "E", "F"}
    );
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"A", "D"},
      new String[] {"B", "E"},
      new String[] {"C", "F"}
    );
    Matrix matrix = new Matrix(input);
    matrix.transpose();
    assertEquals(expected, matrix);
  }
  
  @Test
  public void transpose_differentLengths() {
    ArrayList<ArrayList<String>> input = JunitHelper.arrayList.make(
      new String[] {"A", "B", "C"},
      new String[] {"D", "E"}
    );
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"A", "D"},
      new String[] {"B", "E"},
      new String[] {"C", " "}
    );
    Matrix matrix = new Matrix(input);
    matrix.transpose();
    assertEquals(expected, matrix);
  }
  
  @Test
  public void appendColumn_differentLengths() {
    ArrayList<ArrayList<String>> input = JunitHelper.arrayList.make(
      new String[] {"A"},
      new String[] {"B"}
    );
    ArrayList<String> newColumn = JunitHelper.arrayList.make(
      new String[] {"C", "D", "E"}
    );
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"A", "C"},
      new String[] {"B", "E"},
      new String[] {" ", "F"}
    );
    Matrix matrix = new Matrix(input);
    matrix.appendColumn(newColumn);
    assertEquals(expected, matrix);
  }
}
