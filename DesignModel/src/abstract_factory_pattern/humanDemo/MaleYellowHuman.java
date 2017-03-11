package abstract_factory_pattern.humanDemo;

public class MaleYellowHuman extends AbstractYellowHuman{

	@Override
	public void getSex() {
		System.out.println("黄种人男性");
	}

}
