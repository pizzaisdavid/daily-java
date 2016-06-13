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
    
  }

  private ArrayList<Family> parseFamiles(ArrayList<String> input) {
    // TODO Auto-generated method stub
    return null;
  }
  
  
}
