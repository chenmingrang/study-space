package proxy_pattern.AOP;

import java.lang.reflect.InvocationHandler;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		Subject subject = new RealSubject();
		InvocationHandler handler = new MyInvocationHandler(subject);
		Subject proxy = DynamicProxy.newProxyInstance(subject.getClass()
				.getClassLoader(), subject.getClass().getInterfaces(), handler);
		proxy.doSomething("start");
	}
}
