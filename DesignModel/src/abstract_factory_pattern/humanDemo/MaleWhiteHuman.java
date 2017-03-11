package abstract_factory_pattern.humanDemo;

public class MaleWhiteHuman extends AbstractWhiteHuman{

	@Override
	public void getSex() {
		System.out.println("白人男性");
	}

}
