package basic01;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = -266838822458936871L;
	private Long pid;// 标识属性
	private String pname;
	private String psex;

	public Person() {
	}

	public Person(Long pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPsex() {
		return psex;
	}

	public void setPsex(String psex) {
		this.psex = psex;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex
				+ "]";
	}
}
