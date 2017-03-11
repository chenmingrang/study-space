package factory_pattern.singletonFactory;

public class Singleton {
	private Singleton() {

	}

	public void doSomething() {
		System.out.println("我是单例工厂模式");
	}
}
