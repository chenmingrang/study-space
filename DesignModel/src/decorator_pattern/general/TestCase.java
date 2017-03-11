package decorator_pattern.general;

import org.junit.Test;

public class TestCase {

	@Test
	public void test1(){
		Component component = new ConcreteComponent();
		//第一次修饰
		component = new ConcreteDecorator1(component);
		//第二次修饰
		//component = new ConcreteDecorator2(component);
		component.operate();
	}
}
