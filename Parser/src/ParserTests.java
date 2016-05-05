import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ParserTests {

  @Test
  public void split_Comma() {
    ArrayList<String> output;
    
    output = Parser.parse("This,is,David", ",");
    assertEquals("This", output.get(0));
    assertEquals("is", output.get(1));
    assertEquals("David", output.get(2));
    
    output = Parser.parse("This, is, David", ",");
    assertEquals("This", output.get(0));
    assertEquals("is", output.get(1));
    assertEquals("David", output.get(2));
  }

}
