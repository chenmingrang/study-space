package basic01;

import java.io.Serializable;

public class Person_uuid implements Serializable {
	private static final long serialVersionUID = -266838822458936871L;
	private String pid;// 标识属性
	private String pname;
	private String psex;

	public Person_uuid() {
	}

	public Person_uuid(String pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
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
