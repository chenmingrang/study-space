package abstract_factory_pattern.productDemo;

import org.junit.Test;

public class TsetCase {
	@Test
	public void test1() {
		AbstractCreator creator1=new Creator1();
		AbstractCreator creator2=new Creator2();
		System.out.println("生成对象A");
		AbstractProductA A1=creator1.createAbstractProductA();
		A1.doSomething();
		AbstractProductA A2=creator2.createAbstractProductA();
		A2.doSomething();
		System.out.println("生成对象B");
		AbstractProductB B1=creator1.createAbstractProductB();
		B1.doSomething();
		AbstractProductB B2=creator2.createAbstractProductB();
		B2.doSomething();
	}
}
