package pizza.SimplifyingFractions;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void test() {
		Fraction fraction = new Fraction(4, 8);
		fraction.simplify();
		int numerator = fraction.getNumerator();
		int denominator = fraction.getDenominator();
		assertEquals(1, numerator);
		assertEquals(2, denominator);
	}

}
