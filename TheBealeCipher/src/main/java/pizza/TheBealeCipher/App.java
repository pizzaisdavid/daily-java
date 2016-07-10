package pizza.TheBealeCipher;

import java.util.ArrayList;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class App 
{
	
  public static void main( String[] args )
  {
  	System.out.println( "Hello World!" );
  }
  
	public static ArrayList<String> bealeCipher(ArrayList<String> message, ArrayList<Integer> key) {
		ArrayList<String> output = new ArrayList<String>();
		for (int value : key) {
			output.add(message.get(value - 1));
		}
		return output;
	}
}
