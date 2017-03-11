package command_pattern.general;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1(){
		Invoker invoker=new Invoker();
		Receiver receiver=new ConcreteReceiver1();
		Command command=new ConcreteCommand1(receiver);
		invoker.setCommand(command);
		invoker.action();
	}

}
