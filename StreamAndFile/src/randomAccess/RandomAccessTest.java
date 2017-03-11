package randomAccess;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entity.Employee;

public class RandomAccessTest {
	
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("汤姆-克努斯", 75000.00, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000.00, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000.00, 1990, 3, 15);
		
		//将员工信息写到文件中
		DataOutputStream out = new DataOutputStream(new FileOutputStream("E:\\employee.dat"));
		for (int i = 0; i < staff.length; i++) {
			writeData(out, staff[i]);
//			System.out.println(out.size());
		}
		
		//从文件中读回员工信息
		RandomAccessFile in = new RandomAccessFile("E:\\employee.dat", "r");
//		System.out.println(in.length());
		int n = (int) (in.length()/Employee.RECORD_SIZE);
		Employee[] newStaff = new Employee[n];
		//倒着读
		for(int i=n-1;i>=0;i--){
			newStaff[i] = new Employee();
			in.seek(i*Employee.RECORD_SIZE);
			newStaff[i] = readData(in);
		}
		
		for (int i = 0; i < newStaff.length; i++) {
			System.out.println(newStaff[i]);
		}
	}
	
	/**
	 * @function 将员工信息写入到输出流中
	 * @param out 输出流
	 * @param e 员工
	 * @throws IOException
	 */
	public static void writeData(DataOutput out, Employee e) throws IOException {
		DataIO.writeFixedString(e.getName(),Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireday());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH)+1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * @function 从输入流中读出员工信息
	 * @param in 输入流
	 * @return 员工
	 * @throws IOException
	 */
	public static Employee readData(DataInput in)throws IOException{
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();
		return new Employee(name, salary, y, m, d);
	}
}
