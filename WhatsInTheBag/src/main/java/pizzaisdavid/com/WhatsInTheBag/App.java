package pizzaisdavid.com.WhatsInTheBag;


public class App 
{
  public static void main( String[] args )
  {
    ScrabbleBag bag = new ScrabbleBag();
    bag.subtract("AEERTYOXMCNB_S");
    System.out.println(bag);
  }
}
