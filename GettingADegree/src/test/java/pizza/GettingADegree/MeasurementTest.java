package pizza.GettingADegree;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeasurementTest {

	@Test
	public void test() {
		Measurement m = new Measurement("degree", 90);
		Measurement expected = new Measurement("radians", 1.5708);
		
		assertTrue(m.equals(expected));
	}

}
