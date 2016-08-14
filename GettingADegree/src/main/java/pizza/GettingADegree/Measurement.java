package pizza.GettingADegree;

public class Measurement {
	private String type;
	private double amount;

	public Measurement(String type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public void convertTo(String newType) {
		if (type == "degree" && newType == "radian") {
			convertFromDegreeToRadian();
		} else if (type == "radian" && newType == "degree") {
			convertFromRadianToDegree();
		}
	}
	
	private void convertFromDegreeToRadian() {
		type = "radian";
		amount = Math.toRadians(amount);
		amount = roundDecimal(amount);
	}
	
	private void convertFromRadianToDegree() {
		type = "degree";
		amount = Math.toDegrees(amount);
		amount = roundDecimal(amount);
	}


	private double roundDecimal(double decimal) {
		int DECIMAL_MULTIPLIER = 1000;
		double movedDecimalRight = decimal * DECIMAL_MULTIPLIER;
		double roundedDecimal = Math.round(movedDecimalRight);
		double movedDecimalLeft = roundedDecimal / DECIMAL_MULTIPLIER;
		return movedDecimalLeft;
	}

	public boolean equals(Measurement other) {
		return type == other.getType() && amount == other.getAmount();
	}

	private String getType() {
		return type;
	}
	
	private double getAmount() {
		return amount;
	}
	
	public String toString() {
		return amount + type;
	}
}
