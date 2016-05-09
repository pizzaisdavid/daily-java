package test.java.com.mycompany.daily;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import main.java.com.mycompany.daily.Parser;

public class ParserTest {
  
  public static ArrayList<String> make(String... strings) {
    ArrayList<String> expected = new ArrayList<String>();
    for (String string : strings) {
      expected.add(string);
    }
    return expected;
  }
  
  public static class parse {

    @Test
    public void comma() {
      ArrayList<String>expected = make("This", "is", "David");
      String input = "This,is,David";
      String delimiter = ",";
      assertEquals(expected, Parser.parse(input, delimiter));
    }
    
    @Test
    public void trim() {
      ArrayList<String>expected = make("This", "is", "David");
      String input = "This,   is,   David";
      String delimiter = ",";
      assertEquals(expected, Parser.parse(input, delimiter));
    }
  }
  
  public static class arrayList {
    
    @Test
    public void list() {
      ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>(
        Arrays.asList(
          new ArrayList<String>(Arrays.asList("0.0", "0.1", "0.2")),
          new ArrayList<String>(Arrays.asList("1.0", "1.1", "1.2")),
          new ArrayList<String>(Arrays.asList("2.0", "2.1", "2.2"))
        )
      );
      ArrayList<String> content = make(
        "0.0, 0.1, 0.2",
        "1.0, 1.1, 1.2",
        "2.0, 2.1, 2.2"
      );
      assertEquals(expected, Parser.parse(content));
    }
  }
}