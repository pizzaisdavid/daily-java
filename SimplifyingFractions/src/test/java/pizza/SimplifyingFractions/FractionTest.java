package pizza.SimplifyingFractions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void smallNumberTest() {
		Fraction fraction = new Fraction(4, 8);
		fraction.simplify();
		int numerator = fraction.getNumerator();
		int denominator = fraction.getDenominator();
		assertEquals(1, numerator);
		assertEquals(2, denominator);
	}
	
	@Test
	public void largeNumberTest() {
		Fraction fraction = new Fraction(1536, 78360);
		fraction.simplify();
		int numerator = fraction.getNumerator();
		int denominator = fraction.getDenominator();
		assertEquals(64, numerator);
		assertEquals(3265, denominator);
	}

}
