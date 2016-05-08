import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ParserTests {
  
  public static class parse {

    @Test
    public void comma() {
      String[] expected = {"This", "is", "David"};
      String input = "This,is,David";
      String delimiter = ",";
      ArrayList<String> output = Parser.parse(input, delimiter);
      assertEquals(Arrays.asList(expected), output);
    }
    
    @Test
    public void trim() {
      String[] expected = {"This", "is", "David"};
      String input = "This,   is,   David";
      String delimiter = ",";
      ArrayList<String> output = Parser.parse(input, delimiter);
      assertEquals(Arrays.asList(expected), output);
    }
  }
  
  public static class initialize {
    
    class StubFile extends TextFile {
      
      private ArrayList<String> content;

      public StubFile(String filePath, ArrayList<String> input) {
        super(filePath);
        this.content = input;
      }

      public ArrayList<String> lines() {
        return this.content;
      }
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
      ArrayList<String> content = new ArrayList<String>(
        Arrays.asList(
          "0.0, 0.1, 0.2",
          "1.0, 1.1, 1.2",
          "2.0, 2.1, 2.2"
        )
      );
      StubFile input = new StubFile("test.txt", content);
      String delimiter = ",";
      Parser parser = new Parser(input);
      ArrayList<ArrayList<String>> output = parser.parse(delimiter);
      assertEquals(expected, output);
    }
  }
}