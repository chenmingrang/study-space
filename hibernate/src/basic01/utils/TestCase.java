package basic01.utils;

import org.hibernate.Session;
import org.junit.Test;


public class TestCase {
	BaseDao dao=new BaseDao();;
	@Test
	public void test1() {
		Session session=dao.getSession();
		System.out.println(session);
	}
}
