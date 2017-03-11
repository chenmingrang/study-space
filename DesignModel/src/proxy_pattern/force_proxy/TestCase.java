package proxy_pattern.force_proxy;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		IGamePlayer player=new GamePlayer("张三");
		player.login("zhangsan", "123456");
		player.killBoss();
		player.upgrade();
	}
	
	@Test
	public void test2(){
		IGamePlayer player=new GamePlayer("张三");
		IGamePlayer proxy=new GamePlayerProxy(player);
		proxy.login("zhangsan", "123456");
		proxy.killBoss();
		proxy.upgrade();
	}
	
	@Test
	public void test3(){
		IGamePlayer player=new GamePlayer("张三");
		IGamePlayer proxy=player.getProxy();
		proxy.login("zhangsan", "123456");
		proxy.killBoss();
		proxy.upgrade();
	}
}
