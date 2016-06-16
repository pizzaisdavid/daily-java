package pizzaisdavid.com.CriticalHit;

public class App {
  
  public static void main( String[] args ) {
    CriticalHit critical = new CriticalHit(4);
    System.out.println(critical.computeKillProbability(6));
  }
}
