import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   ParserTests.Parse.class
})

public class ParserTests {
  
  public static class Parse {

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
}