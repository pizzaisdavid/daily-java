package pizzaisdavid.com.WhatsInTheBag;


public class App 
{
  public static void main( String[] args )
  {
    ScrabbleBag bag = new ScrabbleBag();
    bag.remove("AEERTYOXMCNB_S");
    System.out.println(bag);
  }
}
