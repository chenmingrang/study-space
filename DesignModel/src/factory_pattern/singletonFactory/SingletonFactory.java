package factory_pattern.singletonFactory;

import java.lang.reflect.Constructor;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class SingletonFactory {
	private static Singleton singleton;
	static {
		try {
			Class cls = Singleton.class;
			Constructor con = cls.getDeclaredConstructor();
			con.setAccessible(true);
			singleton = (Singleton) con.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Singleton getSingleton() {
		return singleton;
	}
}
