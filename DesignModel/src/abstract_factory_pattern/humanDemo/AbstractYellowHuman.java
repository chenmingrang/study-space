package abstract_factory_pattern.humanDemo;

public abstract class AbstractYellowHuman implements Human{

	@Override
	public void getColor() {
		System.out.println("黄种人肤色是黄色的");
	}

	@Override
	public void talk() {
		System.out.println("黄种人在说话");
	}

}
