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
		assertEquals("Blank string.", false, Main.isNumeric(""));

	}
	
	@Test
	public void isDecmial () {
		assertEquals(true, Main.isNumeric("23.4"));
		assertEquals("Two periods.", false, Main.isNumeric("2.."));
    assertEquals("Peroid then number.", true, Main.isNumeric(".2"));
    assertEquals("Just a peroid", false, Main.isNumeric("."));
	}
}
