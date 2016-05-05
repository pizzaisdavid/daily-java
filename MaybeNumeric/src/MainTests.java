import static org.junit.Assert.*;

import org.junit.Test;

public class MainTests {

	@Test
	public void isWholeNumber() {
		assertEquals(true, Main.isNumeric("234"));
	}
	
	@Test
	public void isString() {
		assertEquals(false, Main.isNumeric("This is a sentence."));
	}
	
	@Test
	public void isDecmial () {
		assertEquals(true, Main.isNumeric("23.4"));
	}
}
