import static org.junit.Assert.*;

import org.junit.Test;

public class addVehicleTest {
	@Test
	public void test() {
		AutoPark test = new AutoPark(5, 10);
		Subscription sbr = new Subscription(new Date(10,05,2019),new Date(30,05,2019),"34AA1234");
		boolean output = test.addVehicle(sbr.getVehicle());
		assertEquals(true, output);
	}

}
