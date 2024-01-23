package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("Production")
public class BClassTest {
	@Test
	@Tag("Production")
	public void testB() {
		System.out.println("testB() called");
	}
}
