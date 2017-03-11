package command_pattern.demo2;

public class AddRequirementCommand extends Command {

	@Override
	public void execute() {
		rg.find();
		rg.add();
		rg.plan();
	}

}
