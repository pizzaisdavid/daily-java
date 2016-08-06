package pizza.SimplifyingFractions;

public class Fraction {
	private int numerator;
	private int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public void simplify() {
		int largerNumber = max(numerator, denominator);
		for (int i = largerNumber; i != 0; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				numerator = numerator / i;
				denominator = denominator / i;
				break;
			}
		}
	}

	private int max(int number1, int number2) {
		if (number1 < number2) {
			return number2;
		}
		return number1;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denominator;
	}

}
