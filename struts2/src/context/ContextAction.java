package context;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ContextAction extends ActionSupport {

	public String test(){
		System.out.println("ContextAction *********** test()");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("username", "username_request");
		
		
		Map sessionMap = ServletActionContext.getContext().getSession();
		sessionMap.put("username", "username_session");
		
		ServletContext sc = ServletActionContext.getServletContext();
		sc.setAttribute("username", "username_application");
		
		return "attr";
	}
	
}
