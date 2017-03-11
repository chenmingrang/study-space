package validate;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ValidateXmlAction extends ActionSupport {

	private String username;
	
	private String psw;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String login(){
		System.out.println("ValidateXmlAction ********** login()");
		return "success";
	}
	
	public String test(){
		System.out.println("ValidateXmlAction ********** test()");
		return "success";
	}
	
}
