package factory_pattern.multiFactory;

public class BlackHumanFactory extends AbstractHumanFactory{

	@Override
	public Human createHuman() {
		return new BlackHuman();
	}
}
