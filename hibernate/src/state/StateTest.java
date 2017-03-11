package state;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 对象的状态
 * 
 * @author Administrator
 * 
 */
public class StateTest {
	private static SessionFactory sessionFactory;
	static {
		Configuration configuration = new Configuration();
		configuration.configure("state/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	@Test
	public void testUpdatePerson() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, 28L);
		person.setPname("Jordan");
		person.setPsex("M");
		session.update(person);
		transaction.commit();
		session.close();
	}

	/**
	 * 该程序发出了 Hibernate: select max(pid) from person
	 * 这条sql语句是在session.save(person);发出的 Hibernate: insert into
	 * hibernate0909.person (pname, psex, pid) values (?, ?, ?)
	 * 是在transaction.commit();发出的 两条sql语句
	 */
	@Test
	public void testSavePerson() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPname("James");
		person.setPsex("M");
		session.close();
		// session已关闭
		session.save(person);
		transaction.commit();
	}

	@Test
	public void testSaveOrUpdate() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();// 临时状态
		person.setPname("James");// 临时状态
		person.setPsex("M");// 临时状态
		session.save(person);// 临时状态转化成持久化状态
		person.setPname("Wade");// 持久化状态
		session.save(person);// 无用，因为已经是持久化状态,最终存入的是wade
		transaction.commit();// 同步到数据库中
		session.close();// 托管状态
	}

	@Test
	public void testUpdatePerson2() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, 28L);
		person.setPname("Jordan");
		/**
		 * 在执行session.update的时候， hibernate内部会为person对象去对照内存快照（副本），如果属性发生改变才要执行
		 * update语句，如果没有改变，则不发出update语句
		 */
		session.update(person);
		transaction.commit();// 并没有发出update语句
		session.close();//关闭时发出更新语句
	}

	/**
	 * 如果执行session.save方法，hibernate内部会检查主键是否存在，如果存在，则不管
	 * 如果执行session.update方法，看属性是否发生变化，如果发生变化，则执行update语句，如果没有发生改变，则不执行
	 * 在hibernate内部，是通过标识符来判断一个对象在数据库中是否有值
	 */
	@Test
	public void testUpdate3() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();
		person.setPid(28L);//如果存在id为28的则发出更新语句,没有则会报错；
		person.setPname("Durant");
		person.setPsex("W");
		session.update(person);
		transaction.commit();
		session.close();
	}

	@Test
	public void testSavePerson3() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = new Person();// 临时状态
		person.setPname("Kobe");
		person.setPsex("M");
		session.save(person);// 持久化状态
		transaction.commit();
		session.close();// 当session关闭以后，事务环境不存在了
		session = sessionFactory.openSession();// 打开了一个新的session,这个时候的session并没有保存person对象
		Transaction transaction2 = session.beginTransaction();
		person.setPname("Bosh");
		session.update(person);// person中的id已经有值了
		transaction2.commit();
		session.close();
	}

	@Test
	public void testaa() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person per = new Person();
//		Person per = (Person)session.get(Person.class, 28L);
		per.setPid(28L);
		per.setPsex("男");
		per.setPname("Steven");
		session.update(per);
		transaction.commit();
		// 数据库中id、name、sex全都一样，为什么还执行update语句？
		session.close();
	}
}
