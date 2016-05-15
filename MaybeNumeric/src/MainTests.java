import static org.junit.Assert.*;

import org.junit.Test;

public class MainTests {

	@Test
	public void isWholeNumber() {
		assertTrue(Main.isNumeric("234"));
    assertTrue(Main.isNumeric("0"));
	}
	
	@Test
	public void isString() {
		assertFalse(Main.isNumeric("This is a sentence."));
		assertFalse("Blank string.", Main.isNumeric(""));
		assertFalse("Just a peroid", Main.isNumeric("."));
    assertFalse("Two periods.", Main.isNumeric("2.."));
	}
	
	 @Test
	  public void isNull() {
	    assertFalse(Main.isNumeric(null));
	  }
	
	@Test
	public void isDecmial () {
		assertTrue(Main.isNumeric("23.4"));
    assertTrue("Peroid then number.", Main.isNumeric(".2"));
	}
}
