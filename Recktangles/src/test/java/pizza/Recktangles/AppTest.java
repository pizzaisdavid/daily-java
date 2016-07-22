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
	ArrayList<ArrayList<String>> expected;
	ArrayList<ArrayList<String>> actual;
	
	@Before
	public void before() {
		
	}

	@Test
	public void test() {
		word = "REKT";
		width = 1;
		height = 1;
    expected = JunitHelper.arrayList.make(
      new String[] {"R","E", "K", "T"},
      new String[] {"E"," ", " ", "K"},
      new String[] {"K"," ", " ", "E"},
      new String[] {"T","K", "E", "R"}
    );
    actual = App.makeSquare(word, width, height);
    assertEquals(expected, actual);
	}

}
