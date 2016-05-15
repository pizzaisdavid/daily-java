package test.java.com.mycompany.daily;

import java.util.ArrayList;

public class JunitHelper {
  
  public static ArrayList<String> make(String... strings) {
    ArrayList<String> expected = new ArrayList<String>();
    for (String string : strings) {
      expected.add(string);
    }
    return expected;
  }
}
