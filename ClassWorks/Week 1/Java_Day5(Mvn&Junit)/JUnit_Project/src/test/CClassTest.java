package test;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CClassTest {
	@Test
	@Tag("Development")
	public void testC() {
		System.out.println("testC() called");
	}
}
