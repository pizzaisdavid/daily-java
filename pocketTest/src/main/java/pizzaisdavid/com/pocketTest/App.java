package pizzaisdavid.com.pocketTest;

public class App 
{
  public static void main( String[] args )
  {
    try {
      RequestToken token = new RequestToken();
      String respsonse = token.get();
      System.out.println(respsonse);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
