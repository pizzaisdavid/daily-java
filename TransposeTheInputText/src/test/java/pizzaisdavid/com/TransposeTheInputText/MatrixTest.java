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
    Column newColumn = new Column(JunitHelper.arrayList.make("C", "D", "E"));
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"A", "C"},
      new String[] {"B", "D"},
      new String[] {" ", "E"}
    );
    Matrix matrix = new Matrix(input);
    matrix.append(newColumn);
    assertEquals(expected, matrix);
  }
}
