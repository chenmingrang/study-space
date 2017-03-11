package converter;

public class Employee {

	/*
	 * 员工姓名:<input type="text" name="name"><br>
        员工薪水:<input type="text" name="salary"><br>
	 */
	private String name;
	
	private Double salary;

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
	
	
}
