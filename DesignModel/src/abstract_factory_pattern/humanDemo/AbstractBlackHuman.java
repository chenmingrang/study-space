package abstract_factory_pattern.humanDemo;

public abstract class AbstractBlackHuman implements Human{

	@Override
	public void getColor() {
		System.out.println("黑种人肤色是黑色的");
	}

	@Override
	public void talk() {
		System.out.println("黑种人在说话");
	}

}
