package command_pattern.general2;

public class ConcreteCommand2 extends Command {

	//默认为接收者2
	public ConcreteCommand2(){
		super(new ConcreteReceiver2());
	}
	
	public ConcreteCommand2(Receiver receiver) {
		super(receiver);
	}

	@Override
	public void execute() {
		receiver.doSomething();
	}

}
