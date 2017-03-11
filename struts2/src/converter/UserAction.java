package converter;

import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UserAction extends ActionSupport {

	/*
	 * 	在struts2框架中，在对应动作类action中，
	 * 	声明与页面中表单元素同名的属性，给出对应的set和get方法。
	 *  struts2框架就会根据反射机制，获取页面中表单元素的值
	 */
	
	//编号:<input type="text" name="id"><br>
	private Integer id;
	
    //姓名:<input type="text" name="userName"><br>
	private String userName;
	
	//出生日期：<input type="text" name="createTime"><br>
	private Date createTime;
	
	/*
	 * 学历编号:<input type="text" name="edu.eduid"><br>
        学历名称:<input type="text" name="edu.eduname"><br>
	 */
	private Edu edu;
	
	/*
	 * 员工姓名:<input type="text" name="name"><br>
        员工薪水:<input type="text" name="salary"><br>
	 */
	Collection<Employee> emps;
	
	public Collection<Employee> getEmps() {
		return emps;
	}

	public void setEmps(Collection<Employee> emps) {
		this.emps = emps;
	}

	public Edu getEdu() {
		return edu;
	}

	public void setEdu(Edu edu) {
		this.edu = edu;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String execute() throws Exception {
		System.out.println("UserAction ************ execute()");
		return "success";
	}
	
	public String save(){
		System.out.println("UserAction ************ save()");
		
		/*HttpServletRequest request = ServletActionContext.getRequest();
		
		String username = request.getParameter("userName");
		
		System.out.println("username = "+username);*/
		
		System.out.println("id = "+id);
		
		System.out.println("username = "+userName);
		
		System.out.println("createTime = "+createTime);
		
		System.out.println(edu.getEduid()+"  "+edu.getEduname());
		
		return "success";
	}
}
