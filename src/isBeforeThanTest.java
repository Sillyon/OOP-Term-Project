import static org.junit.Assert.*;

import org.junit.Test;

public class isBeforeThanTest {
	@Test
	public void test() {
		Date test = new Date(25,9,2018);
		Date other = new Date(16,5,2019);
		boolean output = test.isBeforeThan(other);
		assertEquals(true, output);
	}
}
