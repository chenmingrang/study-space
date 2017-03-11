package abstract_factory_pattern.humanDemo;

public abstract class AbstractWhiteHuman implements Human{

	@Override
	public void getColor() {
		System.out.println("白种人皮肤是白色的");
	}

	@Override
	public void talk() {
		System.out.println("白种人在讲话");
	}
}
