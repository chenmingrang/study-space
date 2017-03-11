package command_pattern.general2;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1(){
		Invoker invoker = new Invoker();
//		//默认接收者为2
//		Command command = new ConcreteCommand2();
		Command command = new ConcreteCommand1(new ConcreteReceiver2());
		invoker.setCommand(command);
		invoker.action();
	}

}
