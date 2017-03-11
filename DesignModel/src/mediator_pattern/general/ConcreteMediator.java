package mediator_pattern.general;

public class ConcreteMediator extends Mediator{

	@Override
	public void doSomething1() {
		c1.self_method1();
		c2.self_method2();
	}

	@Override
	public void doSomething2() {
		c1.self_method1();
		c2.self_method2();
	}
}
