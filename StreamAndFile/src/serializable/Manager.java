package serializable;

public class Manager extends Employee {
	private static final long serialVersionUID = 8880715184477901112L;

	public Manager(String name, Double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
	}

	private Employee secretary;

	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}

}
