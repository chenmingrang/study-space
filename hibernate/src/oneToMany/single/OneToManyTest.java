package oneToMany.single;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * 1、保存班级 
 * 2、保存学生 
 * 3、保存班级的时候同时保存学生 
 * 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系
 * 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
 * 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
 * 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
 * 8、已经存在一个学生，解除该学生和该学生所在班级之间的关系
 * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系
 * 10、解除该班级和所有的学生之间的关系 
 * 11、删除班级 * * 解除该班级和所有的学生之间的关系 * 删除该班级 * 删除班级的同时删除学生
 * 12、删除学生 同删除班级
 * 
 * @author Administrator
 * 
 */
public class OneToManyTest {
	private Session session;
	private Transaction tx;

	@Before
	public void getSession() {
		Configuration configuration = new Configuration();
		configuration.configure("oneToMany/single/hibernate.cfg.xml");
		session = configuration.buildSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	@Test
	// 1、保存班级
	public void testSave_classes() {
		Classes classes = new Classes();
		classes.setCname("三年级二班");
		classes.setDescription("周杰伦上的小学的班级号");
		session.save(classes);
		tx.commit();
		session.close();
	}

	@Test
	// 2、保存学生
	public void testSave_student() {
		Student stu = new Student();
		stu.setSname("周杰伦");
		stu.setDescription("歌唱的不错");
		session.save(stu);
		tx.commit();
		session.close();
	}

	@Test
	// 3、保存班级的时候同时保存学生(casecade级联,inverse="true"不维护关系)
	public void testSaveClassesAndStu() {
		Classes cls = new Classes();
		cls.setCname("Java基础班");
		cls.setDescription("一群没有基础的人在学Java");
		Student stu = new Student();
		stu.setSname("习近平");
		stu.setDescription("班长");
		Set<Student> stus = new HashSet<Student>();
		stus.add(stu);
		cls.setStudents(stus);
		session.save(cls);
		tx.commit();
		session.close();
	}

	// 4、保存班级的时候同时保存学生，并且建立班级和学生之间的关系
	@Test
	public void testSaveClassesAndStu_inverse() {
		Classes cls = new Classes();
		cls.setCname("Java进修班");
		cls.setDescription("一群有工作经验的人在学Java");
		Student stu = new Student();
		stu.setSname("李克强");
		stu.setDescription("团委");
		Set<Student> stus = new HashSet<Student>();
		stus.add(stu);
		cls.setStudents(stus);
		session.save(cls);
		tx.commit();
		session.close();
	}

	// 5、已经存在一个班级，新建一个学生，并且建立该学生和该班级之间的关系
	@Test
	public void testSaveStu_hashClasses() {
		Classes cls = (Classes) session.get(Classes.class, 2L);
		Set<Student> stus = cls.getStudents();
		Student stu = new Student();
		stu.setSname("江泽明");
		stu.setDescription("上一届班长");
		stus.add(stu);
		tx.commit();
		session.close();
	}

	// 6、已经存在一个学生，新建一个班级，并且建立该学生和该班级之间的关系
	@Test
	public void test6() {
		Classes cls = new Classes();
		Student stu = (Student) session.get(Student.class, 2L);
		cls.setCname("金融IT班");
		cls.setDescription("金融方面开发");
		Set<Student> stus = new HashSet<Student>();
		stus.add(stu);
		cls.setStudents(stus);
		session.save(cls);
		tx.commit();
		session.close();
	}

	// 7、已经存在一个学生，已经存在一个班级，解除该学生和原来班级之间的关系，建立该学生和新班级之间的关系
	@Test
	public void test7() {
		Classes cls = (Classes) session.get(Classes.class, 2L);
		Student stu = (Student) session.get(Student.class, 2L);
		Set<Student> stus = cls.getStudents();
		stus.clear();
		stus.add(stu);
		tx.commit();
		session.close();
	}

	// 8、已经存在一个学生，解除该学生和该学生所在班级之间的关系，
	// 知道学生和学生班级
	@Test
	public void test8() {
		Student stu = (Student) session.get(Student.class, 2L);
		Classes cls = (Classes) session.get(Classes.class, 2L);
		cls.getStudents().remove(stu);
		tx.commit();
		session.close();
	}

	// * 9、解除该班级和所有的学生之间的关系，再重新建立该班级和一些新的学员之间的关系

	@Test
	public void test9() {
		Classes cls = (Classes) session.get(Classes.class, 3L);
		Set<Student> stus = cls.getStudents();
		stus.clear();
		Student stu1 = new Student();
		stu1.setSname("刘德华");
		stu1.setDescription("唱忘情水的男人");
		Student stu2 = new Student();
		stu2.setSname("张学友");
		stu2.setDescription("唱吻别的男人");
		stus.add(stu1);
		stus.add(stu2);
		tx.commit();
		session.close();
	}

	// * 10、解除该班级和所有的学生之间的关系

	@Test
	public void test10() {
		Classes cls = (Classes) session.get(Classes.class, 3L);
		Set<Student> stus = cls.getStudents();
		stus.clear();
		tx.commit();
		session.close();
	}

	// * 11、删除班级
	// * *
	// * * 解除该班级和所有的学生之间的关系
	// * * 删除该班级
	// * *
	// * 删除班级的同时删除学生

	@Test
	public void test11() {
		Classes cls = (Classes) session.get(Classes.class, 5L);
		session.delete(cls);// 级联操作all
		tx.commit();
		session.close();
	}

	// * 12、删除学生
	// * 同删除班级
	@Test
	public void test12() {
		Classes cls = (Classes) session.get(Classes.class, 4L);
		cls.getStudents().clear();
		session.delete(cls);// 取消删除级联操作
		tx.commit();
		session.close();
	}
	/**
	 * 总结： 1、在整个例子中，班级负责维护关系，只要班级维护关系就会发出update语句 2、解除关系就是相对应的外键设置为null
	 * 3、改变关系就是相对应的外键从一个值变成另外一个值 4、在代码中的体现： classes.setStudents(); 重新建立关系
	 * classes.getStudents().remove; 解除关系 classes.setStudents(null); 解除所有的关系
	 * classes.getStudents().add() 在原有的关系的基础上再建立关系
	 */
}
