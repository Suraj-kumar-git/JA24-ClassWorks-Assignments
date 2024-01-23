package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class AClassTest {
	
	@Test
	@Tag("Development")
	@Tag("Production")
	public void testA() {
		System.out.println("testA() called");
	}
}
