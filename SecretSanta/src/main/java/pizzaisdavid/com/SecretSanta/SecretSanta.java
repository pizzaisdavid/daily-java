package pizzaisdavid.com.SecretSanta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecretSanta {
  
  private RandomNumberGenerator rng;
  
  public SecretSanta() {
    rng = new RandomNumberGenerator();
  }
  
  public SecretSanta(RandomNumberGenerator newRng) {
    rng = newRng;
  }
  
  public void assign(ArrayList<String> input) {
    ArrayList<Family> families = parseFamiles(input);
    HashMap<String, String> assignments = new HashMap<String, String>();
    
    for (Family family : families) {
      for (String person : family) {
        // TODO rando
      }
    }
    
  }

  private ArrayList<Family> parseFamiles(ArrayList<String> rawFamilies) {
    ArrayList<Family> families = new ArrayList<Family>();
    for (String rawFamily : rawFamilies) {
      families.add(parseFamily(rawFamily));
    }
    return families;
  }

  private Family parseFamily(String rawFamily) {
    Family family = new Family();
    String[] people = rawFamily.split(" ");
    for (String person : people) {
      family.add(person);
    }
    return family;
  }
  
  
  
}
