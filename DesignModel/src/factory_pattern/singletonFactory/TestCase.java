package factory_pattern.singletonFactory;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1(){
		Singleton singleton=SingletonFactory.getSingleton();
		singleton.doSomething();
	}

}
