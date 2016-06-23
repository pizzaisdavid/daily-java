package pizzaisdavid.com.WhatsInTheBag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ScrabbleBag extends HashMap<Character, Integer> {
  private static final long serialVersionUID = 1L;
  private boolean isError;
  private char errorCharacter;

  public ScrabbleBag() {
    isError = false;
    errorCharacter = ' ';
    List<Character> characters = Arrays.asList(
        'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J',
        'K', 'L', 'M', 'N', 'O',
        'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y',
        'Z', '_');
    List<Integer> frequencies = Arrays.asList(
        9, 2, 2, 4, 12,
        2, 3, 2, 9, 1,
        1, 4, 2, 6, 8,
        2, 1, 6, 4, 6,
        4, 2, 2, 1, 2,
        1, 2);
    for (int i = 0; i < characters.size(); i++) {
      char character = characters.get(i);
      int frequency = frequencies.get(i);
      put(character, frequency);
    }
  }

  public void subtract(String string) {
    for (int i = 0; i < string.length(); i++) {
      char character = string.charAt(i);
      subtract(character);
    }
  }

  private void subtract(char character) {
    if (isError == false) {
      iterateDown(character);
    }
  }
  
  private void iterateDown(char character) {
    int value = get(character);
    if (value > 0) {
      value--;
      put(character, value);
    } else {
      isError = true;
      errorCharacter = character;
    }    
  }

  public String toString() {
    if (isError) {
      return "Too many: " + errorCharacter;
    } else {
      String message = "";
      Iterator it = entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        message += pair.getKey() + ": " + pair.getValue() + "\n";
      }
      return message;
    }
    
  }
}
