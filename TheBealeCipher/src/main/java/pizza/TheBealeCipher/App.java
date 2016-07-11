package pizza.TheBealeCipher;

import java.util.ArrayList;

import main.java.com.mycompany.daily.Parser;
import main.java.com.mycompany.daily.TextFile;


public class App 
{
	
  public static void main( String[] args ) {
  	ArrayList<String> words = parseWordsFromFile();
  	ArrayList<Integer> key = parseKeyFromFile();
  	System.out.println(words);
  	System.out.print(key);
  }

	private static ArrayList<String> parseWordsFromFile() {
  	TextFile file = new TextFile("words.txt");
  	ArrayList<String> lines = file.getLines();
  	String content = lines.get(0);
  	return Parser.parse(content, " ");
	}
	
	private static ArrayList<Integer> parseKeyFromFile() {
  	TextFile file = new TextFile("key.txt");
  	ArrayList<String> lines = file.getLines();
  	String content = lines.get(0);
  	return Parser.integersFromList(content);  	
	}

	public static ArrayList<String> bealeCipher(ArrayList<String> message, ArrayList<Integer> key) {
		ArrayList<String> output = new ArrayList<String>();
		for (int value : key) {
			output.add(message.get(value - 1));
		}
		return output;
	}
}
