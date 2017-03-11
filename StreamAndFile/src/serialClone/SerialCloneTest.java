package serialClone;

public class SerialCloneTest {
	public static void main(String[] args) {
		Employee harry = new Employee("Harry Haker", 50000.00, 1989, 12, 1);
		Employee harry2 = (Employee) harry.clone();
		harry.raiseSalary(20);
		//克隆产生新对象
		System.out.println(harry);
		System.out.println(harry2);
	}
}