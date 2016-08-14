package pizza.GettingADegree;

public class App {
	public static void main( String[] args ) {
		Measurement m = new Measurement("degree", 90.0);		
		m.convertTo("radian");
		
		System.out.println(m);
	}
}
