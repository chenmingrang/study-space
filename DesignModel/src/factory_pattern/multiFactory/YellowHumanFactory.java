package factory_pattern.multiFactory;

public class YellowHumanFactory extends AbstractHumanFactory{

	@Override
	public Human createHuman() {
		return new YellowHuman();
	}

}
