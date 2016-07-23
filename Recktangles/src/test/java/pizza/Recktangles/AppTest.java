package pizza.Recktangles;

import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {
	String word;
	int width;
	int height;
	ArrayList<ArrayList<String>> actual;
	
	@Before
	public void before() {
		
	}
	
	@Test
	public void calculateCharacters() {
		word = "REKT";
		width = 2;
		height = 3;
    Square square = new Square(word, width, height);
    square.calculateSquareDimensions();
    assertEquals(7, square.numberOfCharactersWidth);
    assertEquals(10, square.numberOfCharactersHeight);
	}
	
	@Test
	public void createFirstRow() {
		word = "REKT";
		width = 1;
		height = 1;
    ArrayList<String> expected = JunitHelper.arrayList.make("R","E", "K", "T");
    Square square = new Square(word, width, height);
    actual = square.parse();
    assertEquals(expected, actual.get(0));
	}
	
	@Test
	public void createSecondRow() {
		word = "REKT";
		width = 1;
		height = 1;
    ArrayList<String> expected = JunitHelper.arrayList.make("E"," ", " ", "K");
    Square square = new Square(word, width, height);
    actual = square.parse();
    assertEquals(expected, actual.get(1));
	}


	@Test
	public void createSmallSquare() {
		word = "REKT";
		width = 1;
		height = 1;
		ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"T","K", "E", "R"},
      new String[] {"E"," ", " ", "K"},
      new String[] {"K"," ", " ", "E"},
      new String[] {"T","K", "E", "R"}
    );
    Square square = new Square(word, width, height);
    actual = square.parse();
    assertEquals(expected, actual);
	}
	
	@Test
	public void createMediumSquare() {
		word = "REKT";
		width = 1;
		height = 1;
		ArrayList<ArrayList<String>> expected = JunitHelper.arrayList.make(
      new String[] {"T","K", "E", "R", "E", "K", "T"},
      new String[] {"K"," ", " ", "E", " ", " ", "K"},
      new String[] {"E"," ", " ", "K", " ", " ", "E"},
      new String[] {"R","E", "K", "T", "K", "E", "R"},
      new String[] {"K"," ", " ", "E", " ", " ", "K"},
      new String[] {"E"," ", " ", "K", " ", " ", "E"},
      new String[] {"T","K", "E", "R", "E", "K", "T"}
    );
    Square square = new Square(word, width, height);
    actual = square.parse();
    assertEquals(expected, actual);
	}



}
