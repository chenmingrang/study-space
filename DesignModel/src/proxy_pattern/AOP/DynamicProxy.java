package proxy_pattern.AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxy<T> {
	@SuppressWarnings("unchecked")
	public static <T> T newProxyInstance(ClassLoader loader,
			Class<?>[] interfaces, InvocationHandler handler) {
		if (true) {
			new BeforeAdvice().exec();
		}
		return (T)Proxy.newProxyInstance(loader, interfaces, handler);
	}
}
