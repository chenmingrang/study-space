package strategy_pattern.general;

public class ConcreteStrategy2 implements Strategy {

	@Override
	public void doSomething() {
		System.out.println("具体策略二的算法");
	}
}
