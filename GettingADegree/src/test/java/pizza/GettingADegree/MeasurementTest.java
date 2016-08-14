package pizza.GettingADegree;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementTest {

	@Test
	public void test() {
		Measurement m = new Measurement("degree", 90.0);
		Measurement expected = new Measurement("radian", 1.5708);
		
		m.convertTo("radian");
		
		assertTrue(m.equals(expected));
	}

}
