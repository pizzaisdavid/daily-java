package pizza.SimplifyingFractions;

public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public void simplify() {
		for (int i = numerator; i != 0; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator /= i;
				denominator /= i;
				break;
			}
		}
	}
	
	public boolean equals(Fraction other) {
		return numerator == other.getNumerator() && denominator == other.getDenominator();
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

}
