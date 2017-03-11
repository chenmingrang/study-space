package command_pattern.general2;

public class ConcreteCommand1 extends Command {
	//默认自己的接收者
	public ConcreteCommand1(){
		super(new ConcreteReceiver1());
	}
	
	public ConcreteCommand1(Receiver receiver) {
		super(receiver);
	}
	@Override
	public void execute() {
		receiver.doSomething();
	}

}
