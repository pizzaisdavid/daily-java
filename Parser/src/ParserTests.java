import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ParserTests {

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