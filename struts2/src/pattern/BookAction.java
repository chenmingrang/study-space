package pattern;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		System.out.println("BookAction ********* execute()");
		return "success";
	}
	
	/*
	 * 在struts2框架中，action是多实例
	 */
	public BookAction() {
		System.out.println("BookAction的构造方法");
	}

	/*
	 * 自定义方法：
	 * 		* 由public来修饰的
	 * 		* 必须是String返回类型
	 * 		* 不能传参数
	 * 		* 方法名自定义
	 * 
	 * 	* 总之，一句话：除了方法名与execute()不一样，其他所有内容都一样。
	 * 
	 */
	public String add() throws Exception {
		System.out.println("BookAction ********* add()");
		return "add";
	}
	
	public String delete() throws Exception {
		System.out.println("BookAction ********* delete()");
		return "success";
	}
	
	public String find() throws Exception {
		System.out.println("BookAction ********* find()");
		return "success";
	}
	
}
