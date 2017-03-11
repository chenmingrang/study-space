package factory_pattern.multiFactory;

public class WhiteHumanFactory extends AbstractHumanFactory{

	@Override
	public Human createHuman() {
		return new WhiteHuman();
	}

}
