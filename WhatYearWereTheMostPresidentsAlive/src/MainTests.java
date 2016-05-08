import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import main.java.com.mycompany.daily.Parser;
import org.junit.Test;

public class MainTests {

  @Test
  public void test() {
    String[] expected = {
        "George Washington",
        "Feb 22 1732",
        "Westmoreland Co. Va.",
        "Dec 14 1799",
        "Mount Vernon Va."
        };
    String input = "George Washington,  Feb 22 1732,    Westmoreland Co. Va.,   Dec 14 1799,    Mount Vernon Va.";
    String delimiter = ",";
    ArrayList<String> output = Parser.parse(input, delimiter);
    
    assertEquals(Arrays.asList(expected), output);
  }

}
