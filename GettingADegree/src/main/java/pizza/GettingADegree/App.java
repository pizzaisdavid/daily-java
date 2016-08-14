package pizza.GettingADegree;

public class App {
	public static void main( String[] args ) {
		Measurement m = new Measurement("radian", 1.5708);
		m.convertTo("degree");
		System.out.println(m);
	}
}
