package serialClone;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends SerailCloneable{
	private static final long serialVersionUID = -7028198595096807149L;
	private String name;
	private Double salary;
	private Date hiredate;

	public Employee(String _name, double _salary, int year, int month, int day) {
		name = _name;
		salary = _salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		hiredate = calendar.getTime();
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void raiseSalary(double byPercent){
		double raise = salary*byPercent/100;
		salary += raise;
	}

	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", hiredate="
				+ hiredate + "]";
	}
}
