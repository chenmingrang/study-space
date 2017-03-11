package resulttype;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ResulttypeAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("ResulttypeAction ************ execute()");
		
		//struts2框架将request封装成一个map集合，通过struts2框架提供工具类ServletActionContext的getRequest()方法来获取request
		HttpServletRequest request = ServletActionContext.getRequest();
		
		request.setAttribute("username", "username_request");
		
		return "success";
	}
	
}
