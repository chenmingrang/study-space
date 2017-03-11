package aop;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

@SuppressWarnings("serial")
public class ExpessionInterceptor implements Interceptor {

	public void init() {
		System.out.println("ExpessionInterceptor ********* init()");

	}

	@SuppressWarnings("rawtypes")
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("ExpessionInterceptor ********* intercept()");
		
		//cn.itcast.aop.UserAction@15b5783，动作类的对象
		System.out.println("invocation.getAction() : "+invocation.getAction());
		
		//cn.itcast.aop.UserAction@15b5783，与invocation.getAction()方法获取的是同一的对象
		System.out.println("invocation.getProxy().getAction() : "+invocation.getProxy().getAction());
		
		//userAction_save，自定义配置文件中的action标签的name属性的值
		System.out.println("invocation.getProxy().getActionName() : "+invocation.getProxy().getActionName());
		
		//save，对应动作类指定要执行的方法名
		System.out.println("invocation.getProxy().getMethod() : "+invocation.getProxy().getMethod());
		
		//	/aop，自定义配置文件中的package标签的namespace属性的值
		System.out.println("invocation.getProxy().getNamespace() : "+invocation.getProxy().getNamespace());
		
		//null	返回结果
		System.out.println("invocation.getResult() : "+invocation.getResult());
		
		Map sessionMap = ServletActionContext.getContext().getSession();
		
		Object obj = sessionMap.get("user");
		
		if(obj==null||obj.equals("")){
			return "error";
		}else{
			return "success";
		}
	}
	
	public void destroy() {
		System.out.println("ExpessionInterceptor ********* destroy()");

	}

}
