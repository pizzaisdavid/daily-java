package pizzaisdavid.com.pocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class App 
{
  public static void main( String[] args )
  {
    try {
      sendPostJava();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  private static void sendPostJava() throws Exception {

    String url = "https://getpocket.com/v3/oauth/request";
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    con.setDoOutput(true);
    con.setDoInput(true);
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    con.setRequestProperty("X-Accept", "application/x-www-form-urlencoded");

    String payload="{\"consumer_key\":\""
    + ConsumerKey.getMac() 
    + "\",\"redirect_uri\":\"https://www.google.com\"}";

    OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
    writer.write(payload);
    writer.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + url);
    System.out.println("Post parameters : " + payload);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    
    System.out.println(response.toString());

  }
}
