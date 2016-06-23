package pizzaisdavid.com.WhatsInTheBag;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ScrabbleBag extends HashMap<String, Integer> {
  private static final long serialVersionUID = 1L;

  public ScrabbleBag() {
    List<String> chars = Arrays.asList(
        "A", "B", "C", "D", "E",
        "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O",
        "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y",
        "Z", "_");
    List<Integer> frequency = Arrays.asList(
        9, 2, 2, 4, 12,
        2, 3, 2, 9, 1,
        1, 4, 2, 6, 8,
        2, 1, 6, 4, 6,
        4, 2, 2, 1, 2,
        1, 2);
    for (int i = 0; i < chars.size(); i++) {
      String character = chars.get(i);
      int occurrences = frequency.get(i);
      put(character, occurrences);
    }
  }

  public void remove(String string) {
    // TODO Auto-generated method stub
  }

}
