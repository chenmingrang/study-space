package manyToMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

/**
 * 1、保存课程 2、保存学生 3、保存课程的时候同时保存学生 4、保存课程的时候同时保存学生，并且建立课程和学生之间的关系
 * 5、已经存在一个课程，新建一个学生，并且建立该学生和该课程之间的关系 6、已经存在一个学生，新建一个课程，并且建立该学生和该课程之间的关系
 * 7、已经存在一个学生，已经存在一个课程，解除该学生和原来课程之间的关系，建立该学生和新课程之间的关系
 * 8、已经存在一个学生，解除该学生和该学生的所有的课程之间的关系 9、解除该课程和所有的学生之间的关系，再重新建立该课程和一些新的学员之间的关系
 * 10、解除该课程和所有的学生之间的关系 11、删除课程 * * 解除该班级和所有的学生之间的关系 * 删除该班级 * 删除班级的同时删除学生
 * 12、删除学生 同删除班级
 * 
 * @author Administrator
 * 
 */
public class TestCase {
	private static Session session = null;

	@Before
	public void beforeTest() {
		Configuration configuration = new Configuration();
		configuration.configure("manyToMany/hibernate.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	/**
	 * 保存课程
	 */
	@Test
	public void testSaveCourse() {
		Transaction transaction = session.beginTransaction();
		Course course = new Course();
		course.setCname("java");
		course.setDescription("Java编程");
		session.save(course);
		transaction.commit();
		session.close();
	}

	/**
	 * 保存学生
	 */
	@Test
	public void testSaveStudent() {
		Transaction transaction = session.beginTransaction();
		Student student = new Student();
		student.setSname("习近平");
		student.setDescription("中国最大的boss");
		session.save(student);
		transaction.commit();
		session.close();
	}

	/**
	 * 保存课程同时保存学生 Hibernate: select max(cid) from Course Hibernate: select
	 * max(sid) from Student Hibernate: insert into Course (cname, description,
	 * cid) values (?, ?, ?) Hibernate: insert into Student (sname, description,
	 * sid) values (?, ?, ?) 往Course表和Student表中分别插入了一行数据，和关系表没有关系
	 * 通过映射文件可以看出，Student维护关系,但是从代码中找不到维护关系的代码(inverse="true")
	 */
	@Test
	public void testSaveCourse_Cascade() {
		Transaction transaction = session.beginTransaction();
		 // 新建一个课程
		Course course = new Course();
		course.setCname("中共特高科");
		course.setDescription("共产党特务机构");
		// 新建一个学生
		Student student = new Student();
		student.setSname("周恩来");
		student.setDescription("主任");

		Set<Student> students = new HashSet<Student>();
		students.add(student);
		
		//通过课程建立课程与学生之间的关系
		course.setStudents(students);// 因为课程是一个新的，所以根据没有学生
		session.save(course);
		transaction.commit();
		session.close();
	}

	/**
	 * 保存课程同时保存学生，并且建立关系cascade="save-update"，学生维护关系
	 */
	@Test
	public void testSaveCourse_Cascade_R() {
		Transaction transaction = session.beginTransaction();
		//新建课程
		Course course = new Course();
		course.setCname("中央政治局常委进修班");
		course.setDescription("一群大boss");
		Set<Course> courses = new HashSet<Course>();
		courses.add(course);
		//新建学生
		Student student = new Student();
		student.setSname("习近平");
		student.setDescription("班长");
		//通过学生建立学生和课程之间的关系
		student.setCourse(courses);
		session.save(student);
		transaction.commit();
		session.close();
	}

	/**
	 * 已经存在一个课程，新建一个学生，并且建立该学生和该课程之间的关系 Hibernate: select course0_.cid as
	 * cid0_0_, course0_.cname as cname0_0_, course0_.description as
	 * descript3_0_0_ from Course course0_ where course0_.cid=? Hibernate:
	 * select max(sid) from Student Hibernate: insert into Student (sname,
	 * description, sid) values (?, ?, ?) Hibernate: insert into student_course
	 * (sid, cid) values (?, ?) 该sql语句是维护关系
	 */
	@Test
	public void testSaveStudent_R() {
		Transaction transaction = session.beginTransaction();
		/**
		 * 1、查找一个课程 2、新建一个学生 3、通过学生来维护该学生和课程之间的关系
		 */
		// 查找课程2
		Course course = (Course) session.get(Course.class, 3L);
		// 新建一个学生
		Student student = new Student();
		student.setSname("李克强");
		student.setDescription("副班长");
		// 通过学生来维护该学生和课程之间的关系
		Set<Course> courses = new HashSet<Course>();
		courses.add(course);
		student.setCourse(courses);
		session.save(student);
		transaction.commit();
		session.close();
	}

	/**
	 * 已经存在一个学生，新建一个课程，并且建立该学生和该课程之间的关系
	 */
	@Test
	public void testSaveCourse_R() {
		Transaction transaction = session.beginTransaction();
		/**
		 * 1、新建一个课程 2、查找学生 3、在学生原来的基础上新添加一门课程
		 */
		// 新建课程
		Course course = new Course();
		course.setCname("老一辈无产阶级革命家");
		course.setDescription("共产党的创始人们");
		// 查找学生
		Student student = (Student) session.get(Student.class, 2L);
		Set<Course> courses = student.getCourse();// 获取该学生现在所有的课程
		courses.add(course);//级联操作，保存course
		transaction.commit();
		session.close();
	}

	/**
	 * 已经存在一个学生，已经存在一个课程，解除该学生和原来一个课程之间的关系，建立该学生和新的一个课程之间的关系
	 */
	@Test
	public void testRealse_Rebuild_R() {
		/*
		 * 分析： * 从需求分析上看，这个例子就是关系的操作 * 要查看谁来维护关系，通过映射文件可以看出，Student来维护关系 * 步骤 *
		 * 查询sid为5的学生 * 得到该学生的所有的课程 * 遍历课程 有可能有两种操作： * 先移除集合中的一个元素，再添加 *
		 * 直接修改集合中的元素 多对多的关系的维护包括两个操作 第三张表的增加、删除
		 */
		Transaction transaction = session.beginTransaction();
		// 得到sid为5的学生
		Student student = (Student) session.get(Student.class, 2L);
		// 得到cid为1的课程
		Course course3 = (Course) session.get(Course.class, 3L);
		// 得到该学生的所有的课程
		Set<Course> courses = student.getCourse();
		for (Course course : courses) {
			if (course.getCid().longValue() == 2) {
				courses.remove(course);// 先移除
				break;
			}
		}
		courses.add(course3);// 增加
		transaction.commit();
		session.close();
	}

	/**
	 * 已经存在一个学生，已经存在多个课程，解除该学生和原来多个课程之间的关系，建立该学生和新的多个课程之间的关系
	 */
	@Test
	public void testRealse_Rebuild_R_Many() {
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 2L);
		Course course2 = (Course) session.get(Course.class, 2L);
		Course course4 = (Course) session.get(Course.class, 4L);
		Set<Course> courses = student.getCourse();
		for (Course course : courses) {
			// 在关系表中把sid为5,cid为1 sid为5，cid为3的两行删除
			if (course.getCid().longValue() == 1
					|| course.getCid().longValue() == 3) {
				courses.remove(course);
				break;//没break的话ConcurrentModificationException
			}
		}
		courses.add(course4);
		courses.add(course2);
		transaction.commit();
		session.close();
	}

	/*
	 * 已经存在一个学生，解除该学生和该学生的所有的课程之间的关系
	 */
	@Test
	public void testRealse_R() {
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 2L);
		student.setCourse(null);// 解除该学生和所有的课程之间的关系
		transaction.commit();
		session.close();
	}

	/**
	 * 解除该课程和所有的学生之间的关系，再重新建立该课程和一些新的学员之间的关系 
	 *    说明： * 必须由学生来维护关系 * 已经条件是课程
	 *           cid-->course-->set<student>-->遍历每一个student
	 *           -->从每一个student中得到所有的课程-->找到要移除的课程-->移除
	 */
	@Test
	public void testRealse_R_C() {
		Transaction transaction = session.beginTransaction();
		Course course = (Course) session.get(Course.class, 3L);
		Set<Student> students = course.getStudents();
		for (Student student : students) {
			Set<Course> courses = student.getCourse();
			for (Course course2 : courses) {
				if (course2.getCid().longValue() == 4) {//学过课程3的学生不在学课程4
					courses.remove(course2);
					break;
				}
			}
		}
		Student student5 = (Student) session.get(Student.class, 5L);
		Student student6 = (Student) session.get(Student.class, 6L);
		student5.getCourse().add(course);
		student6.getCourse().add(course);
		transaction.commit();
		session.close();
	}

	/**
	 * 解除该课程和所有的学生之间的关系
	 */
}
