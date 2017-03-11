package entity;

import java.util.Calendar;
import java.util.Date;

public class Employee {
	public static final int NAME_SIZE=40;
	public static final int RECORD_SIZE=100;
	private String name;
	private Double salary;
	private int year;
	private int month;
	private int day;

	public Employee(){}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}


	public Employee(String name, Double salary, int year, int month, int day) {
		super();
		this.name = name;
		this.salary = salary;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", year="
				+ year + ", month=" + month + ", day=" + day + "]";
	}

	public Date getHireday() {
		Calendar c=Calendar.getInstance();
		c.set(year, month-1, day);
		return c.getTime();
	}

}
