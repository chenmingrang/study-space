package oneToMany.dbl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class TestCase {
	private Session session;
	private Transaction tx;

	@Before
	public void getSession() {
		Configuration configuration = new Configuration();
		configuration.configure("oneToMany/dbl/hibernate.cfg.xml");
		session = configuration.buildSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	@Test
	// * 1、保存班级 
	public void test1() {
		Classes cls=new Classes();
		cls.setCname("NBA全明星班");
		cls.setDescription("一群打球不错的人");
		session.save(cls);
		tx.commit();
		session.close();
	}
	

	// * 2、保存学生 
	@Test 
	public void test2(){
		Student stu=new Student();
		stu.setSname("Jordan");
		stu.setDescription("air man");
		session.save(stu);
		tx.commit();
		session.close();
	}
	
	// * 3、保存班级的时候同时保存学生 (casecade,inverse=true班级不维护关系)
	@Test
	public void test3(){
		Classes cls=new Classes();
		cls.setCname("football stars");
		cls.setDescription("play football very well");
		Student stu=new Student();
		stu.setSname("罗纳尔多");
		stu.setDescription("肥罗");
		Set<Student> stus=new HashSet<Student>();
		stus.add(stu);
		cls.setStudents(stus);
		session.save(cls);
		tx.commit();
		session.close();
	}
	
	// * 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系(学生casecade,学生维护关系)
	@Test
	public void test4(){
		Classes cls=new Classes();
		cls.setCname("film stars");
		cls.setDescription("都是影帝");
		Student stu=new Student();
		stu.setSname("莱昂纳多");
		stu.setDescription("小李子");
		stu.setClasses(cls);
		session.save(stu);
		tx.commit();
		session.close();
	}
	
	// * 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
	@Test
	public void test5(){
		Classes cls=(Classes) session.get(Classes.class, 1L);
		Student stu=new Student();
		stu.setSname("Wade");
		stu.setDescription("the flashman");
		stu.setClasses(cls);
		session.save(stu);
		tx.commit();
		session.close();
	}
	
	// * 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
	@Test
	public void test6(){
		Student stu=(Student) session.get(Student.class, 5L);
		Classes cls=new Classes();
		cls.setCname("111");
		cls.setDescription("222");
		stu.setClasses(cls);//casecade
		tx.commit();
		session.close();
	}
	
	// * 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
	@Test
	public void test7(){
		Classes cls=(Classes) session.get(Classes.class, 1L);
		Student stu=(Student) session.get(Student.class, 5L);
		stu.setClasses(cls);
		tx.commit();
		session.close();
	}
	
	// * 8、已经存在一个学生，解除该学生和该学生所在班级之间的关系
	@Test
	public void test8(){
		Student stu=(Student) session.get(Student.class, 5L);
		stu.setClasses(null);
		tx.commit();
		session.close();
	}
	
	// * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系
	@Test
	public void test9(){
		Classes cls=(Classes) session.get(Classes.class, 1L);
		Set<Student> stus=cls.getStudents();
		for (Student student : stus) {
			student.setClasses(null);//解除关系
		}
		//stus.clear();//不维护关系,此语句无用
		Student stu1=new Student();
		stu1.setSname("Kobe");
		stu1.setDescription("Lakers star");
		stu1.setClasses(cls);
		stus.add(stu1);
		Student stu2=new Student();
		stu2.setSname("Bosh");
		stu2.setDescription("Heat star");
		stu2.setClasses(cls);
		stus.add(stu2);
		tx.commit();
		session.close();
	}
	
	// * 10、解除该班级和所有的学生之间的关系 
	@Test
	public void test10(){
		Classes cls=(Classes) session.get(Classes.class, 1L);
		Set<Student> stus=cls.getStudents();
		for (Student student : stus) {
			student.setClasses(null);//解除关系
		}
		tx.commit();
		session.close();
	}
	
	// * 11、删除班级 * * 解除该班级和所有的学生之间的关系 * 删除该班级 * 删除班级的同时删除学生
	@Test
	public void test11(){
		Classes cls=(Classes) session.get(Classes.class, 5L);
		session.delete(cls);//级联操作，同时删除学生
		tx.commit();
		session.close();
	}
	
	// * 12、删除学生 同删除班级
	@Test
	public void test12(){
		Student stu=(Student) session.get(Student.class,2L);
		session.delete(stu);
		tx.commit();
		session.close();
	}
	
	//最终结论是 ：“一”维护关系，“多”级联操作
}
