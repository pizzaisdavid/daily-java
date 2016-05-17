package test.java.com.mycompany.daily;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import main.java.com.mycompany.daily.Parser;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class ParserTest {
  
  @Test
  public void init() {
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
  public void list() {
    ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>(
      Arrays.asList(
        new ArrayList<String>(Arrays.asList("0.0", "0.1", "0.2")),
        new ArrayList<String>(Arrays.asList("1.0", "1.1", "1.2")),
        new ArrayList<String>(Arrays.asList("2.0", "2.1", "2.2"))
      )
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
    ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>(
      Arrays.asList(
        new ArrayList<String>(Arrays.asList("George Washington", "Feb 22 1732", "Dec 14 1799"))
      )
    );
    ArrayList<String> input = JunitHelper.arrayList.make(
      "PRESIDENT,  BIRTH DATE, DEATH DATE",
      "George Washington,  Feb 22 1732,    Dec 14 1799"
    );
    assertEquals(expected, Parser.parseExcludingHeader(input));

  }
}