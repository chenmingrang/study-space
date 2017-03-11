package command_pattern.general2;

public abstract class Command {
	public final Receiver receiver;
	
	public Command(Receiver _receiver){
		this.receiver = _receiver;
	}

	public abstract void execute();
}
