package redis.clients.jedis;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Antonio Tomac <antonio.tomac@mediatoolkit.com>
 */
public class TupleTest {

	/**
	 * 如果element与score有一个相等则相等，否则比较比较score值
	 * @date 2017年5月28日
	*  @fun
	 */
	@Test
	public void testCompareTo() {
		Tuple t1 = new Tuple("foo", 1.0);
		Tuple t2 = new Tuple("bar", 1.0);
		Tuple t3 = new Tuple("elem3", 2.0);
		Tuple t4 = new Tuple("foo", 10.0);

		assertEquals(0, t1.compareTo(t2));
		assertEquals(0, t2.compareTo(t1));

		assertEquals(-1, t1.compareTo(t3));
		assertEquals(1, t3.compareTo(t1));

		assertEquals(0, t1.compareTo(t4));
		assertEquals(0, t4.compareTo(t1));
	}

}
