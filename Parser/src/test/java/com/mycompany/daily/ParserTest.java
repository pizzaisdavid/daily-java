package test.java.com.mycompany.daily;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import main.java.com.mycompany.daily.Parser;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class ParserTest {
  
  @Test
  public void initialize() {
    @SuppressWarnings("unused")
    Parser parser = new Parser();
  }
  
  @Test
  public void comma() {
    ArrayList<String> expected = JunitHelper.arrayList.make("This", "is", "David");
    String input = "This,is,David";
    String delimiter = ",";
    assertEquals(expected, Parser.parse(input, delimiter));
  }
  
  @Test
  public void trim() {
    ArrayList<String> expected = JunitHelper.arrayList.make("This", "is", "David");
    String input = "This,   is,   David";
    String delimiter = ",";
    assertEquals(expected, Parser.parse(input, delimiter));
  }
  
  @Test
  public void numberList() {
    ArrayList<Integer> expected = JunitHelper.arrayList.make(1, 2, 3);
    String input = "1, 2, 3";
    assertEquals(expected, Parser.integersFromList(input));
  }
  
  @Test
  public void list() {
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
        new String[] {"0.0","0.1", "0.2"},
        new String[] {"1.0","1.1", "1.2"},
        new String[] {"2.0","2.1", "2.2"}
      );
    ArrayList<String> input =  JunitHelper.arrayList.make(
      "0.0, 0.1, 0.2",
      "1.0, 1.1, 1.2",
      "2.0, 2.1, 2.2"
    );
    assertEquals(expected, Parser.parse(input));
  }
  
  @Test
  public void exludeHeader() {
    ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
        new String[] {"George Washington", "Feb 22 1732", "Dec 14 1799"},
        new String[] {"John Adams", "Oct 30 1735", "July 4 1826"}
      );
    ArrayList<String> input = JunitHelper.arrayList.make(
      "PRESIDENT,  BIRTH DATE, DEATH DATE",
      "George Washington,  Feb 22 1732,    Dec 14 1799",
      "John Adams,  Oct 30 1735,  July 4 1826"
    );
    assertEquals(expected, Parser.parseExcludingHeader(input));
  }
}