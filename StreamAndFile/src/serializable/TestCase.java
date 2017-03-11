package serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() throws IOException, ClassNotFoundException {
		Employee harry = new Employee("Harry Hacker", 70000.00, 1987, 1, 15);
		Manager carl = new Manager("Carl Cracker", 80000.00, 1985, 2, 12);
		carl.setSecretary(harry);
		Manager tony = new Manager("Tony Tester", 40000.00, 1990, 3, 16);
		tony.setSecretary(harry);
		
		Employee[] emps = new Employee[3];
		emps[0] = harry;
		emps[1] = carl;
		emps[2] = tony;
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emps.dat"));
		oos.writeObject(emps);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emps.dat"));
		Employee[] emps_serial = (Employee[]) ois.readObject();
		
		Manager m1 = (Manager) emps_serial[1];
		Manager m2 = (Manager) emps_serial[2];
		//为同一个秘书，引用同一个对象
		System.out.println(m1.getSecretary()==m2.getSecretary());
		
		for (int i = 0; i < emps_serial.length; i++) {
			System.out.println(emps_serial[i]);
		}
	}
}
