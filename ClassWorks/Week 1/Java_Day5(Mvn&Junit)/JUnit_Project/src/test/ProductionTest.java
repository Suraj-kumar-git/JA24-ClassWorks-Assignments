package test;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"./test"})
@IncludeTags("Development")
public class ProductionTest {
	@Test
	void testProduction() {
		System.out.println("Production Test Class");
	}
}
