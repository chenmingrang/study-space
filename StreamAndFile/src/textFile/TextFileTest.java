package textFile;

import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import entity.Employee;

public class TextFileTest {
	public static void main(String[] args) throws Exception{
		Employee[] staff=new Employee[3];
		staff[0]=new Employee("Carl Cracker", 75000d, 1987, 12, 15);
		staff[1]=new Employee("Harry Hacker", 50000d, 1989, 10, 1);
		staff[2]=new Employee("Carl Cracker", 40000d, 1990, 3, 12);
		PrintWriter out=new PrintWriter("E:\\employee.dat","UTF-8");
	    writeData(staff, out);
	    out.flush();
	    out.close();
	    Scanner in=new Scanner(new FileInputStream("E:\\employee.dat"),"UTF-8");
	    Employee[] newStaff=readData(in);
	    for (Employee e:newStaff) {
			System.err.println(e);
		}
	}
	
	private static void writeData(Employee[] staff,PrintWriter pw)throws Exception{
		//第一行写出长度
		pw.println(staff.length);
		for (int i = 0; i < staff.length; i++) {
			//每行写出一个员工信息
			writeEmployee(pw,staff[i]);
		}
	}

	private static void writeEmployee(PrintWriter pw, Employee e) {
		GregorianCalendar calendar=new GregorianCalendar();
		System.out.println(e.getHireday());
		calendar.setTime(e.getHireday());
		pw.println(e.getName()+"|"+e.getSalary()+"|"+calendar.get(Calendar.YEAR)+"|"
		           +(calendar.get(Calendar.MONTH)+1)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	private static Employee[] readData(Scanner in){
		//员工个数
		int n=in.nextInt();
		//consume newline
		in.nextLine();
		
		Employee[] employees=new Employee[n];
		for (int i = 0; i < n; i++) {
			employees[i]=readEmployee(in);
		}
		return employees;
	}

	private static Employee readEmployee(Scanner in) {
		String line=in.nextLine();
		String [] tokens=line.split("\\|");
		String name = tokens[0];
		double salary=Double.parseDouble(tokens[1]);
		int year=Integer.parseInt(tokens[2]);
		int month=Integer.parseInt(tokens[3]);
		int day=Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);
	}
}
