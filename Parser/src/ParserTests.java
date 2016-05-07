import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  ParserTests.parse.class,
  ParserTests.initialize.class,
  ParserTests.object.class
})

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
    
    class StubFile extends File {
      
      private ArrayList<String> input;

      public StubFile(String filePath) {
        super(filePath);
      }
      
      public void setLines(ArrayList<String> input) {
        this.input = input;
      }

      public ArrayList<String> lines() {
        return this.input;
      }
    }
    
    @Test
    public void list() {
      ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
      ArrayList<String> content = new ArrayList<String>();
      StubFile file = new StubFile("test.txt");
      String delimiter = ",";

      expected.add(new ArrayList<String>(Arrays.asList("0.0", "0.1", "0.2")));
      expected.add(new ArrayList<String>(Arrays.asList("1.0", "1.1", "1.2")));
      expected.add(new ArrayList<String>(Arrays.asList("2.0", "2.1", "2.2")));
      content.add("0.0, 0.1, 0.2");
      content.add("1.0, 1.1, 1.2");
      content.add("2.0, 2.1, 2.2");

      file.setLines(content);
      Parser parser = new Parser(file);
      
      ArrayList<ArrayList<String>> output = parser.parse(delimiter);
      
      assertEquals(expected, output);
    }
  }
  
  public static class object {
    
    @Test
    public void test() {
      // TODO make an arrayList of custom objects.
    }
    
  }
}