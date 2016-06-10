package pizzaisdavid.com.TransposeTheInputText;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {

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
    assertEquals(expected, App.transpose(input));
  }
  
  @Test
  public void test_differentLengths() {
    ArrayList<ArrayList<String>> input = JunitHelper.arrayList.make(
      new String[] {"A", "B", "C"},
      new String[] {"D", "E"}
    );
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"A", "D"},
      new String[] {"B", "E"},
      new String[] {"C", " "}
    );
    assertEquals(expected, App.transpose(input));
  }

}
