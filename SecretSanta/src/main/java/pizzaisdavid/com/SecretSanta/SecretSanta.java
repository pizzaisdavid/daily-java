package pizzaisdavid.com.SecretSanta;

import java.util.ArrayList;
import java.util.HashMap;

public class SecretSanta {
  
  @SuppressWarnings("unused")
	private RandomNumberGenerator rng;
  
  public SecretSanta() {
    rng = new RandomNumberGenerator();
  }
  
  public SecretSanta(RandomNumberGenerator rng) {
    this.rng = rng;
  }
  
  public void assign(ArrayList<String> input) {
    //ArrayList<Family> families = parseFamiles(input);
    @SuppressWarnings("unused")
    HashMap<String, String> assignments = new HashMap<String, String>();
    
//    for (Family family : families) {
//      for (String person : family) {
//        // TODO rando
//      }
//    }
//    
  }

  @SuppressWarnings("unused")
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
