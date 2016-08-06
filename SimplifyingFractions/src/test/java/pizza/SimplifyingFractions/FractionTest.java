package pizza.SimplifyingFractions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void smallNumberTest() {
		Fraction expected = new Fraction(1, 2);
		Fraction actual = new Fraction(4, 8);		
		actual.simplify();
		assertTrue(actual.equals(expected));
	}
	
	@Test
	public void largeNumberTest() {
		Fraction expected = new Fraction(64, 3265);
		Fraction actual = new Fraction(1536, 78360);
		actual.simplify();
		assertTrue(actual.equals(expected));
	}

}
