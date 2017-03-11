package command_pattern.demo2;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		Invoker commander=new Invoker();
		Command command=new AddRequirementCommand();
		commander.setCommand(command);
		commander.action();
	}

	@Test 
	public void test2(){
		Invoker commander=new Invoker();
		Command command=new DeletePageCommand();
		commander.setCommand(command);
		commander.action();
	}
}
