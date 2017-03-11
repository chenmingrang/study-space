package proxy_pattern.generalDemo;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
	   Subject realsSubject=new RealSubject();
	   Proxy proxy=new Proxy(realsSubject);
	   proxy.request();
	}
}
