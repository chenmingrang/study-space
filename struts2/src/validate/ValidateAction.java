package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ValidateAction extends ActionSupport {

	private String username;
	
	private String psw;
	
	public void setUsername(String username) {
		System.out.println("ValidateAction ************ setUsername()");
		this.username = username;
	}
	
	/*
	 * 验证方法：
	 * 	* 该动作类action必须继承ActionSupport或者实现Validateable接口
	 * 	* 必须重写Validateable接口提供的validate()方法
	 * 
	 * 	* 必须要保证setUsername()、validate()、login()方法的执行顺序如下：
	 * 		* setUsername()
	 * 		* validate()
	 * 		* login()
	 * 
	 *  * 如果登录失败，如何处理：
	 *  	* this.addFieldError( key, value);
	 *  		* key：错误提示字段
	 *  		* value：错误提示信息
	 * 
	 *  * 通过底层代码说明：
	 *  	public synchronized void addFieldError(String fieldName, String errorMessage) {
		        final Map<String, List<String>> errors = internalGetFieldErrors();		//声明一个map集合
		        List<String> thisFieldErrors = errors.get(fieldName);					//声明一个list集合，放入对应错误提示信息
		
		        if (thisFieldErrors == null) {										//如果list集合为空
		            thisFieldErrors = new ArrayList<String>();							//重新创建一个list集合
		            errors.put(fieldName, thisFieldErrors);								//把list集合放入到map集合中
		        }
		
		        thisFieldErrors.add(errorMessage);										//把错误提示信息放入到list集合中
		    }
	 * 
	 * 	* 什么时候才是验证通过？
	 * 		* 验证通过：1、map集合不存在；2、map集合存在并为空
	 * 		* 验证不通过：map集合存在并且不为空
	 * 
	 * 	* 分析需求：
	 * 		* 用户名不能为null ,""
	 		* 密码不能为null, "" ，并且密码的长度6-12之间 
	 * 
	 * 	* 针对所有业务方法进行验证还是针对某个指定业务方法进行验证？
	 * 		* 重写的validate()方法，针对所有业务方法进行验证
	 * 		* 重写的validate()方法加上要验证的指定的业务方法名(业务方法名的首字母大写)，实现针对某个指定的业务方法进行验证
	 * 			* 为什么要这样进行拼接？因为struts2框架底层拼接，如果不这样写，底层就找不到对应方法名
	 * 	
	 */
	public void validateLogin() {
		System.out.println("ValidateAction ************ validate()");
		
		if(username==null||username.equals("")){
			this.addFieldError("name", "用户名不能为空！");
		}
		
		if(psw==null||psw.equals("")){
			this.addFieldError("pwd", "密码不能为空！");
		}else{
			
			String pattern = "^[0-9a-zA-Z]{6,12}$";
			
			Pattern p = Pattern.compile(pattern);
			
			Matcher m = p.matcher(psw);
			
			boolean b = m.matches();
			
			if(!b){
				this.addFieldError("pwd", "密码的长度必须在6至12之间！");
			}
			
		}
		
	}
	
	public String login(){
		System.out.println("ValidateAction ********* login()");
		
		System.out.println("username = "+username);
		
		System.out.println("password = "+psw);
		
		return "success";
	}
	
	public String test(){
		System.out.println("ValidateAction ********* test()");
		return "success";
	}

	public String getUsername() {
		return username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
	
}
