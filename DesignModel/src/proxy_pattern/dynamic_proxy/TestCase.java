package proxy_pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		IGamePlayer player=new GamePlayer("张三");
		InvocationHandler handler=new GamePlayIH(player);
		IGamePlayer proxy=(IGamePlayer) Proxy.newProxyInstance(player.getClass().getClassLoader(), new Class[]{IGamePlayer.class}, handler);
		proxy.login("张三", "123456");
		proxy.killBoss();
		proxy.upgrade();
	}
}
