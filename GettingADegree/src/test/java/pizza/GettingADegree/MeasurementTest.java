package pizza.GettingADegree;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementTest {

	@Test
	public void convertDegreeToRadian() {
		Measurement m = new Measurement("degree", 90.0);
		Measurement expected = new Measurement("radian", 1.571);
		m.convertTo("radian");
		assertTrue(m.equals(expected));
	}
	
	@Test
	public void convertRadianToDegree() {
		Measurement m = new Measurement("radian", 1.5708);
		Measurement expected = new Measurement("degree", 90.0);
		m.convertTo("degree");
		assertTrue(m.equals(expected));
	}

}
