package proxy_pattern.demo1;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		IGamePlayer proxy=new GamePlayerProxy("张三");
		proxy.login("zs", "123456");
		proxy.killBoss();
		proxy.upgrade();
	}
}
