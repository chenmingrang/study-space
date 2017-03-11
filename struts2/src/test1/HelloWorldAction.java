package test1;

import org.junit.Test;

import com.opensymphony.xwork2.Action;

public class HelloWorldAction implements Action {

	public String execute() throws Exception {
		System.out.println("HelloWorldAction ************* execute()");
		return "success";
	}

	@Test
	public void test1(){
		String str=(String)null;
		System.out.println(str);
	}
}
