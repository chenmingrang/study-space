package aop;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	public String save(){
		System.out.println("UserAction ************* save()");
		return "success";
	}
	
}
