package loginI18n;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 4309371472199262883L;

	private String username;
	private String pwd;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String execute() throws Exception {
		if(!"tom".equals(username)){
			return "regist";
		}
		if(!"123456".equals(pwd)){
			return "error";
		}
		return "success";
	}
	
	public String welcome(){
		String username=this.getText("login.username");
		ServletActionContext.getRequest().setAttribute("username", "jeffy");
		return "success";
	}
}
