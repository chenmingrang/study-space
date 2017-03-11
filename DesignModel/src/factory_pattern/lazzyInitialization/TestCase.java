package factory_pattern.lazzyInitialization;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() throws Exception{
		Product product=ProductFactory.createProduct("Product1");
		product.doOther();
		product=ProductFactory.createProduct("Product4");
		product.doOther();
	}
}
