package strategy_pattern.general;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		Strategy strategy =new ConcreteStrategy1();
		Context context = new Context(strategy);
		context.doAnything();
	}
	
	@Test
	public void test2(){
		Strategy strategy = new ConcreteStrategy2();
		Context context = new Context(strategy);
		context.doAnything();
	}
}
