package pizzaisdavid.com.BasicFormatting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {

  @Test
  public void test() {
    ArrayList<String> expected = JunitHelper.arrayList.make(
      "VAR I",
      "FOR I=1 TO 31",
      "····IF !(I MOD 3) THEN",
      "········PRINT \"FIZZ\"",
      "····ENDIF"
    );
    ArrayList<String> input = JunitHelper.arrayList.make(
      "VAR I",
      "·FOR I=1 TO 31",
      "»»»»IF !(I MOD 3) THEN",
      "··PRINT \"FIZZ\"",
      "··»»ENDIF"
    );  
    
    
    assertEquals(expected, App.format(input));
  }

}
