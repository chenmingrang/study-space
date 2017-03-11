package basic01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;


public class TestCase {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction tx;
	@Before
	public void before(){
		Configuration configuration = new Configuration();
		//加载配置文件
		//如果在classpath下则不用写（hibernate.cfg.xml）
		configuration.configure("basic01/hibernate.cfg.xml");
		//采用了工厂模式创建sessionFactory
		sessionFactory = configuration.buildSessionFactory();
		session=sessionFactory.openSession();
	}
	
	//增加
	@Test
	public void testSave(){
		tx=session.beginTransaction();
		Person p1=new Person();
		p1.setPname("张三");
		p1.setPsex("M");
		session.save(p1);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testUpdate(){
		tx=session.beginTransaction();
		Person p=(Person) session.get(Person.class, 1L);
		p.setPname("不详");
		p.setPsex("F");
		tx.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testQuery(){
		tx=session.beginTransaction();
		List<Person> pList=session.createQuery("from Person").list();
		for (Person person : pList) {
			System.out.println(person);
		}
	}
	
	//删除
	@Test
	public void testDelete(){
		tx=session.beginTransaction();
		//Person p=(Person) session.get(Person.class, 1L);
		Person person=new Person();
		person.setPid(1L);
		session.delete(person);
		tx.commit();
		session.close();
	}
	
	/**
	 * 以下操作要修改相应的配置文件<id>标签
	 */
	@Test
	//通过Java类来赋值
	public void testIdGenerator_assigned(){
		tx=session.beginTransaction();
		Person p=new Person();
		p.setPid(23L);
		p.setPname("Jordan");
		p.setPsex("M");
		session.save(p);
		tx.commit();
		session.close();
	}
	
	//由于 identity 生成标识符的机制依赖于底层数据库系统,要求底层数据库把主键定义为自动增长字段类型
	@Test
	public void testIdGenerator_identity(){
		tx=session.beginTransaction();
		Person p=new Person();
		p.setPname("James");
		p.setPsex("M");
		session.save(p);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testIdGenerator_increment(){
		tx=session.beginTransaction();
		Person p=new Person();
		p.setPname("Wade");
		p.setPsex("M");
		session.save(p);
		tx.commit();
		session.close();
	}

	//uuid做主键
	@Test
	public void testIdGenerator_uuid(){
		tx=session.beginTransaction();
		Person_uuid p=new Person_uuid();
		p.setPname("Wade");
		p.setPsex("M");
		session.save(p);
		tx.commit();
		session.close();
	}
}
