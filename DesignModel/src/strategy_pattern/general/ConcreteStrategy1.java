package strategy_pattern.general;

public class ConcreteStrategy1 implements Strategy {

	@Override
	public void doSomething() {
		System.out.println("具体策略一的算法");
	}
}
