package pizzaisdavid.com.pocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import pizzaisdavid.com.pocketTest.ConsumerKey;

public class RequestToken {
  
  public RequestToken() {
    
  }
  
  public String get() throws Exception {
    String url = "https://getpocket.com/v3/oauth/request";
    URL obj = new URL(url);
    HttpsURLConnection connection = (HttpsURLConnection) obj.openConnection();

    connection.setDoOutput(true);
    connection.setDoInput(true);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
    connection.setRequestProperty("X-Accept", "application/x-www-form-urlencoded");

    String redirect = "https://www.google.com";
    String payload = formatParameters(ConsumerKey.getMac(), redirect);

    OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
    writer.write(payload);
    writer.close();

    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    
    return response.toString().substring(5);
  }
  
  private String formatParameters(String key, String address) {
    return "{\"consumer_key\":\""
        + ConsumerKey.getMac() 
        + "\",\"redirect_uri\":\""
        + address
        + "\"}";
  }
}
