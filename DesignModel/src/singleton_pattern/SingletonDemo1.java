package singleton_pattern;

public class SingletonDemo1 {
	//饿汉模式
	private static final SingletonDemo1 SINGLETON = new SingletonDemo1();

	//限制多个对象产生
	private SingletonDemo1() {

	}

	public static SingletonDemo1 getSingletonDemo1() {
		return SINGLETON;
	}
	//类中其他方法尽量为静态的
	public static void doSomething(){}
}
