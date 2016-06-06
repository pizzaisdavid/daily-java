package pizzaisdavid.com.Verifying3x3MagicSquares;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {
  
  @Test
  public void validInput() {
    List<Integer> square = JunitHelper.arrayList.make(8, 1, 6, 3, 5, 7, 4, 9, 2);
    assertTrue(App.isMagicSquare(square));
  }
  
  @Test
  public void invalidInput() {
    List<Integer> square = JunitHelper.arrayList.make(3, 5, 7, 8, 1, 6, 4, 9, 2);
    assertFalse(App.isMagicSquare(square));
  }
  
  @Test
  public void getRow_validInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        0, 1, 2,
        3, 4, 5,
        6, 7, 8
    );
    List<Integer> row0 = JunitHelper.arrayList.make(0, 1, 2);
    List<Integer> row1 = JunitHelper.arrayList.make(3, 4, 5);
    List<Integer> row2 = JunitHelper.arrayList.make(6, 7, 8);
    assertEquals(row0, App.getRow(square, 0));
    assertEquals(row1, App.getRow(square, 3));
    assertEquals(row2, App.getRow(square, 6));
  }
  
  @Test
  public void areRowsMagic_invalidInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        1, 1, 1,
        1, 1, 1,
        1, 1, 1
    );
    assertFalse(App.areRowsMagic(square));
  }
  
  @Test
  public void areRowsMagic_validInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        13, 1, 1,
        1, 13, 1,
        1, 1, 13
    );
    assertTrue(App.areRowsMagic(square));
  }
  
  @Test
  public void areColumnsMagic_invalidInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        1, 1, 1,
        1, 1, 1,
        1, 1, 1
    );
    assertFalse(App.areColumnsMagic(square));
  }
  
  @Test
  public void areColumnsMagic_validInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        13, 1, 1,
        1, 13, 1,
        1, 1, 13
    );
    assertTrue(App.areColumnsMagic(square));
  }
  
  @Test
  public void geColumn_validInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        0, 1, 2,
        3, 4, 5,
        6, 7, 8
    );
    List<Integer> column0 = JunitHelper.arrayList.make(0, 3, 6);
    List<Integer> column1 = JunitHelper.arrayList.make(1, 4, 7);
    List<Integer> column2 = JunitHelper.arrayList.make(2, 5, 8);
    assertEquals(column0, App.getColumn(square, 0));
    assertEquals(column1, App.getColumn(square, 1));
    assertEquals(column2, App.getColumn(square, 2));
  }
  
  
  @Test
  public void computeDimensionLength_validInput() {
    List<Integer> square = JunitHelper.arrayList.make(
        1, 1, 1,
        1, 1, 1,
        1, 1, 1
    );
    assertEquals(3, App.computeDimensionLength(square)); 
  }
}
