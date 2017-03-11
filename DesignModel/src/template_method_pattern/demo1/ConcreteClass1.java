package template_method_pattern.demo1;

public class ConcreteClass1 extends AbstractClass {

	@Override
	protected void doSomething1() {
		System.out.println("concreteClass1 do something1");
	}

	@Override
	protected void doSomething2() {
		System.out.println("concreteClass1 do something2");
	}

}
