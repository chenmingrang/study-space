package proxy_pattern.force_proxy2;

import org.junit.Test;

public class TestCase {
	@Test
	public void test3(){
		IGamePlayer player=new GamePlayer("张三");
		IGamePlayer proxy=player.getProxy();
		proxy.login("zhangsan", "123456");
		proxy.killBoss();
		proxy.upgrade();
	}
}
