package pizza.TheBealeCipher;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.pizzaisdavid.JunitHelper.JunitHelper;

public class AppTest {

	@Test
	public void BealeCipher_inOrder() {
		ArrayList<String> message = JunitHelper.arrayList.make("This", "is", "a", "test");
		ArrayList<Integer> key = JunitHelper.arrayList.make(1, 2, 3, 4);
		ArrayList<String> output = JunitHelper.arrayList.make("This", "is", "a", "test");
		assertEquals(output, App.bealeCipher(message, key));
	}
	
	@Test
	public void BealeCipher_outOfOrder() {
		ArrayList<String> message = JunitHelper.arrayList.make("is", "This", "a", "test");
		ArrayList<Integer> key = JunitHelper.arrayList.make(2, 1, 3, 4);
		ArrayList<String> output = JunitHelper.arrayList.make("This", "is", "a", "test");
		assertEquals(output, App.bealeCipher(message, key));
	}
}
