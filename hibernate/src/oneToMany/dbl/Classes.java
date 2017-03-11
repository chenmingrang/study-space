package oneToMany.dbl;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable{
	private static final long serialVersionUID = 6418406730594578548L;
	private Long cid;
	private String cname;
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private Set<Student> students;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
