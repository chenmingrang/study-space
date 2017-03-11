package i18n;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class I18nAction extends ActionSupport {

	public String login(){
		System.out.println("I18nAction ************* login()");
		
		String username = this.getText("items.username");
		System.out.println("username = "+username);
		
		String psw = this.getText("items.psw");
		System.out.println("password = "+psw);
		
		return "success";
	}
	
}
