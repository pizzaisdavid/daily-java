package pizzaisdavid.com.BasicFormatting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {

  @Test
  public void format_validInput() {
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
  
  @Test
  public void stripIndentation() {
    assertEquals("ENDIF", App.stripIndentation("··»»ENDIF"));
  }
  
  @Test
  public void shouldIncreaseIndentLevel() {
    assertTrue(App.shouldIncreaseIndentLevel("IF !(I MOD 3) THEN"));
    assertTrue(App.shouldIncreaseIndentLevel("FOR I=1 TO 31"));
    assertFalse(App.shouldIncreaseIndentLevel("VAR I"));
  }
  
  @Test
  public void shouldDecreaseIndentLevel() {
    assertTrue(App.shouldDecreaseIndentLevel("ENDIF"));
    assertFalse(App.shouldDecreaseIndentLevel("VAR I"));
  }
  
  @Test
  public void parseFirstWord() {
    assertEquals("IF", App.parseFirstWord("IF !(I MOD 3) THEN"));
    assertEquals("ENDIF", App.parseFirstWord("ENDIF"));
  }
  
  @Test
  public void isElementInArray() {
    ArrayList<String> sequence = new ArrayList<String>();
    sequence.add("cat");
    sequence.add("dog");
    assertTrue(App.isElementInArray("cat", sequence));
    assertFalse(App.isElementInArray("fish", sequence));
  }
}
