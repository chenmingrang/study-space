package redis.clients.jedis.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.InvalidURIException;

public class JedisPoolTest {
	private static HostAndPort hnp = HostAndPortUtil.getRedisServers().get(0);

	/*===========================默认地址与端口号===========================*/
	@Test
	public void checkConnections() {
		//默认localhost 端口6379
		JedisPool pool = new JedisPool(new JedisPoolConfig(),"192.168.186.133",
				6379, 2000);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "bar");
		assertEquals("bar", jedis.get("foo"));
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkCloseableConnections() throws Exception {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "bar");
		assertEquals("bar", jedis.get("foo"));
		jedis.close();
		pool.close();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkConnectionWithDefaultPort() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "bar");
		assertEquals("bar", jedis.get("foo"));
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkJedisIsReusedWhenReturned() {

		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "0");
		jedis.close();

		jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.incr("foo");
		assertEquals("1", jedis.get("foo"));
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkPoolRepairedWhenJedisIsBroken() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
//		jedis.quit();//关闭连接，下面的链接会报错  redis.clients.jedis.exceptions.JedisConnectionException: Unexpected end of stream.

		jedis.close();//释放资源，不会关闭连接

		jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.incr("foo");
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkPoolOverflow() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(2);//当最大连接数1时，不执行close方法 而获取新的对象则会报错
		config.setBlockWhenExhausted(false);
		JedisPool pool = new JedisPool(config, "192.168.186.133", 6379);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "0");
//		jedis.close();//若果不关闭连接，则不能获取新的对象

		Jedis newJedis = pool.getResource();
		newJedis.auth("foobared");
		newJedis.incr("foo");
		assertEquals("1", jedis.get("foo"));
		jedis.close();
		pool.destroy();
	}

	@Test
	public void securePool() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setTestOnBorrow(true);
		JedisPool pool = new JedisPool(config, "192.168.186.133", 6379,
				2000, "foobared");
		Jedis jedis = pool.getResource();
		jedis.set("foo", "bar");
		jedis.close();
		pool.destroy();
		assertEquals("bar", jedis.get("foo"));
		assertTrue(pool.isClosed());
	}

	@Test
	public void nonDefaultDatabase() {
		//默认数据库为0
		JedisPool pool0 = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "foobared");
		Jedis jedis0 = pool0.getResource();
		jedis0.set("foo", "bar");
		assertEquals("0", ""+jedis0.getDB());
		assertEquals("bar", jedis0.get("foo"));
		jedis0.close();
		pool0.destroy();
		assertTrue(pool0.isClosed());

		//使用数据库1
		JedisPool pool1 = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "foobared", 1);
		Jedis jedis1 = pool1.getResource();
		assertNull(jedis1.get("foo"));
		jedis1.close();
		pool1.destroy();
		assertTrue(pool1.isClosed());
	}
	/*===========================默认地址与端口号===========================*/
	
	
	@Test
	public void startWithUrlString() {
		Jedis j = new Jedis("192.168.186.133", 6379);
		j.auth("foobared");
		j.select(2);
		j.set("foo", "bar");
		JedisPool pool = new JedisPool("redis://:foobared@192.168.186.133:6379/2");
		Jedis jedis = pool.getResource();
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
		j.quit();
		j.close();
	}

	@Test
	public void startWithUrl() throws URISyntaxException {
		Jedis j = new Jedis("192.168.186.133", 6379);
		j.auth("foobared");
		j.select(2);
		j.set("foo", "bar");
		JedisPool pool = new JedisPool(new URI(
				"redis://:foobared@192.168.186.133:6379/2"));
		Jedis jedis = pool.getResource();
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
		j.quit();
		j.close();
	}

	@Test(expected = InvalidURIException.class)
	public void shouldThrowInvalidURIExceptionForInvalidURI()
			throws URISyntaxException {
		JedisPool pool = new JedisPool(new URI("192.168.186.133:6379"));//非法的资源地址
	}

	@Test
	public void allowUrlWithNoDBAndNoPassword() throws URISyntaxException {
		new JedisPool("redis://192.168.186.133:6379");
		new JedisPool(new URI("redis://192.168.186.133:6379"));
	}

	@Test
	public void selectDatabaseOnActivation() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "foobared");

		Jedis jedis0 = pool.getResource();
		assertEquals("0",""+jedis0.getDB());

		jedis0.select(1);
		assertEquals("1",""+jedis0.getDB());

		jedis0.close();

		Jedis jedis1 = pool.getResource();
		assertTrue("Jedis instance was not reused", jedis1 == jedis0);//jedis1 == jedis0 true
		jedis1.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void customClientName() {
		JedisPool pool0 = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "foobared", 0, "myRedis");

		Jedis jedis = pool0.getResource();

		assertEquals("myRedis", jedis.clientGetname());

		jedis.close();
		pool0.destroy();
		assertTrue(pool0.isClosed());
	}

	@Test
	public void returnResourceDestroysResourceOnException() {

		class CrashingJedis extends Jedis {
			@Override
			public void resetState() {
				throw new RuntimeException();
			}
		}

		final AtomicInteger destroyed = new AtomicInteger(0);

		class CrashingJedisPooledObjectFactory implements
				PooledObjectFactory<Jedis> {

			@Override
			public PooledObject<Jedis> makeObject() throws Exception {
				return new DefaultPooledObject<Jedis>(new CrashingJedis());
			}

			@Override
			public void destroyObject(PooledObject<Jedis> p) throws Exception {
				destroyed.incrementAndGet();
			}

			@Override
			public boolean validateObject(PooledObject<Jedis> p) {
				return true;
			}

			@Override
			public void activateObject(PooledObject<Jedis> p) throws Exception {
			}

			@Override
			public void passivateObject(PooledObject<Jedis> p) throws Exception {
			}
		}

		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(1);
		JedisPool pool = new JedisPool(config, "192.168.186.133", 6379,
				2000, "foobared");
		pool.initPool(config, new CrashingJedisPooledObjectFactory());
		Jedis crashingJedis = pool.getResource();

		try {
			crashingJedis.close();
		} catch (Exception ignored) {
		}

		assertEquals(destroyed.get(), 1);
	}

	@Test
	public void returnResourceShouldResetState() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(1);
		config.setBlockWhenExhausted(false);
		JedisPool pool = new JedisPool(config, "192.168.186.133", 6379,
				2000, "foobared");

		Jedis jedis = pool.getResource();
		try {
			jedis.set("hello", "jedis");
			Transaction t = jedis.multi();
			t.set("hello", "world");
			t.exec();
		} finally {
			jedis.close();
		}

		Jedis jedis2 = pool.getResource();
		try {
			assertTrue(jedis == jedis2);
			assertEquals("world", jedis2.get("hello"));
		} finally {
			jedis2.close();
		}

		pool.destroy();
		assertTrue(pool.isClosed());
	}

	@Test
	public void checkResourceIsCloseable() {
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		config.setMaxTotal(1);
		config.setBlockWhenExhausted(false);
		JedisPool pool = new JedisPool(config, "192.168.186.133", 6379,
				2000, "foobared");

		Jedis jedis = pool.getResource();
		try {
			jedis.set("hello", "jedis");
		} finally {
			jedis.close();
		}

		Jedis jedis2 = pool.getResource();
		try {
			assertEquals(jedis, jedis2);
		} finally {
			jedis2.close();
		}
	}

	@Test
	public void getNumActiveIsNegativeWhenPoolIsClosed() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "foobared", 0, "my_shiny_client_name");

		pool.destroy();
		System.out.println(pool.getNumActive());//-1
		assertTrue(pool.getNumActive() < 0);
	}

	@Test
	public void getNumActiveReturnsTheCorrectNumber() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000);
		Jedis jedis = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "bar");
		assertEquals("bar", jedis.get("foo"));

		assertEquals(1, pool.getNumActive());

		Jedis jedis2 = pool.getResource();
		jedis.auth("foobared");
		jedis.set("foo", "bar");

		assertEquals(2, pool.getNumActive());

		jedis.close();
		assertEquals(1, pool.getNumActive());

		jedis2.close();

		assertEquals(0, pool.getNumActive());

		pool.destroy();
	}

	@Test
	public void testAddObject() {
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000);
		pool.addObjects(1);
		assertEquals(pool.getNumIdle(), 1);
		pool.destroy();

	}

	@Test
	public void testCloseConnectionOnMakeObject() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setTestOnBorrow(true);
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.186.133",
				6379, 2000, "wrong pass");
		Jedis jedis = new Jedis("redis://:foobared@192.168.186.133:6379/");
		int currentClientCount = getClientCount(jedis.clientList());
		try {
			pool.getResource();
			fail("Should throw exception as password is incorrect.");
		} catch (Exception e) {
			assertEquals(currentClientCount, getClientCount(jedis.clientList()));
		}

	}

	private int getClientCount(final String clientList) {
		return clientList.split("\n").length;
	}

}
