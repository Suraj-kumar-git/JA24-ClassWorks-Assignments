package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.Calculator;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator cal = new Calculator();
		int actual =cal.add(4,5);
		assertEquals(9,actual);
	}

	@Test
	void testSub() {
		Calculator cal = new Calculator();
		int actual = cal.sub(4,5);
		assertEquals(1,actual);
	}
	
	@Test
	void testMul() {
		Calculator cal = new Calculator();
		int actual = cal.mul(4,5);
		assertEquals(20,actual);
	}
	
	@Test
	void testDiv() {
		Calculator cal = new Calculator();
		int actual = cal.div(40,8);
		assertEquals(5,actual);
	}

}
