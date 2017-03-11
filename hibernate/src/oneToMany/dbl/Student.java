package oneToMany.dbl;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = -3530297999934667385L;
	private Long sid;
	private String sname;
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
	
	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	private Classes classes;
}
