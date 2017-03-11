package singleton_pattern;

public class SingletonDemo2 {
	//懒汉模式
	private static SingletonDemo2 singletonDemo2 = null;

	private SingletonDemo2() {

	}

	//在并发的情况下，该方式并不安全
	public static SingletonDemo2 getSingletonDemo2() {
		if (singletonDemo2 == null) {
			singletonDemo2 = new SingletonDemo2();
		}
		return singletonDemo2;
	}
}
