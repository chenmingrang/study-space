package optimize.fetch;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * 抓取策略
 *    根据一个对象怎么样提取它的关联对象
 * @author Administrator
 *
 */
public class FetchTest {
	private static SessionFactory sessionFactory;
	static{
		Configuration configuration = new Configuration();
		//加载配置文件
		configuration.configure("optimize/fetch/hibernate.cfg.xml");
		//采用了工厂模式创建sessionFactory
		sessionFactory = configuration.buildSessionFactory();
	}
	/*
	 *  *  查询所有的班级
	 *  *  根据班级中的每一个cid去学生表中进行查询
	 *    n+1条查询
	 */
	@Test
	public void testQueryClasses(){
		Session session = sessionFactory.openSession();
		List<Classes> classesList =  session.createQuery("from Classes").list();
		for(Classes classes:classesList){
			Set<Student> students = classes.getStudents();
			for(Student student:students){
				System.out.println(student.getSname());
			}
		}
		session.close();
	}
	/**
	 * 查询班级cid为2,3,4,5,6的所有的学生
	 */
	@Test
	public void testQueryClassesWhenCid(){
		Session session = sessionFactory.openSession();
		List<Classes> classesList =  session.createQuery("from Classes where cid in(2,3,4,5,6)").list();
		for(Classes classes:classesList){
			Set<Student> students = classes.getStudents();
			//Hibernate: select students0_.cid as cid0_1_, students0_.sid as sid1_, students0_.sid as sid1_0_, students0_.sname as sname1_0_, students0_.description as descript3_1_0_, students0_.cid as cid1_0_ from Student students0_ 
			//           where students0_.cid in (select classes0_.cid from Classes classes0_ where classes0_.cid in (2 , 3 , 4 , 5 , 6))
			//子查询
			for(Student student:students){
				System.out.println(student.getSname());
			}
		}
		session.close();
	}
	/**
	 * 如果抓取策略改成join
	 *   Hibernate: select classes0_.cid as cid0_1_, 
	 *             classes0_.cname as cname0_1_, 
	 *             classes0_.description as descript3_0_1_, 
	 *             students1_.cid as cid0_3_, 
	 *             students1_.sid as sid3_, 
	 *             students1_.sid as sid1_0_, 
	 *             students1_.sname as sname1_0_, 
	 *             students1_.description as descript3_1_0_, 
	 *             students1_.cid as cid1_0_ 
	 *             from Classes classes0_ left outer join Student students1_ on classes0_.cid=students1_.cid 
	 *             where classes0_.cid=?
	 *    从sql语句可以看出，join用的是左外连接
	 *    用join该需求变成一条sql语句
	 *    
	 * join 
	 *    Hibernate: select classes0_.cid as cid0_1_, classes0_.cname as cname0_1_, classes0_.description as descript3_0_1_, students1_.cid as cid0_3_, students1_.sid as sid3_, students1_.sid as sid1_0_, students1_.sname as sname1_0_, students1_.description as descript3_1_0_, students1_.cid as cid1_0_ from Classes classes0_
	 *               left outer join Student students1_ on classes0_.cid=students1_.cid where classes0_.cid=?
	 * select:
	 *       Hibernate: select classes0_.cid as cid0_0_, classes0_.cname as cname0_0_, classes0_.description as descript3_0_0_ from Classes classes0_ where classes0_.cid=?
             Hibernate: select students0_.cid as cid0_1_, students0_.sid as sid1_, students0_.sid as sid1_0_, students0_.sname as sname1_0_, students0_.description as descript3_1_0_, students0_.cid as cid1_0_ from Student students0_ 
                        where students0_.cid=?
                        
        subselect:
        
             Hibernate: select classes0_.cid as cid0_0_, classes0_.cname as cname0_0_, classes0_.description as descript3_0_0_ from Classes classes0_ where classes0_.cid=?
             Hibernate: select students0_.cid as cid0_1_, students0_.sid as sid1_, students0_.sid as sid1_0_, students0_.sname as sname1_0_, students0_.description as descript3_1_0_, students0_.cid as cid1_0_ from Student students0_
                        where students0_.cid=?
             
	 *    
	 */
	@Test
	public void testQueryClassesByCid(){
		Session session = sessionFactory.openSession();
		Classes classes = (Classes)session.get(Classes.class,2L);
		Set<Student> students = classes.getStudents();
		for(Student student:students){
			System.out.println(student.getSname());
		}
		session.close();
	}
}
