package pizza.GettingADegree;

public class Measurement {
	private String type;
	private double amount;

	public Measurement(String type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public void convertTo(String newType) {
		if (type == newType) {
			
		}
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
}
