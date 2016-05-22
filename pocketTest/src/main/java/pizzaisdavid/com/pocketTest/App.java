package pizzaisdavid.com.pocketTest;

public class App 
{
  public static void main( String[] args )
  {
    try {
      RequestToken token = new RequestToken();
      String t = token.get();
      System.out.println("Code: " + t);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
