package abstract_factory_pattern.humanDemo;

public class FemaleWhiteHuman extends AbstractWhiteHuman{

	@Override
	public void getSex() {
		System.out.println("白人女性");
	}
}
