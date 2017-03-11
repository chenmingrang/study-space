package abstract_factory_pattern.humanDemo;

public class MaleFactory implements HumanFactory{

	@Override
	public Human createYellowHuman() {
		return new MaleYellowHuman();
	}

	@Override
	public Human createWhiteHuman() {
		return new MaleWhiteHuman();
	}

	@Override
	public Human createBlackHuman() {
		return new MaleBlackHuman();
	}

}
