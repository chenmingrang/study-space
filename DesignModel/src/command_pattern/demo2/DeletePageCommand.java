package command_pattern.demo2;

public class DeletePageCommand extends Command {

	@Override
	public void execute() {
		pg.find();
		pg.delete();
		pg.plan();
	}

}
