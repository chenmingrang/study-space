package oneToMany.single;

import java.io.Serializable;

public class Student implements Serializable{
	private static final long serialVersionUID = 1205876328397932675L;
	private Long sid;
	private String sname;
	private String description;//不能用数据库的关键字
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
