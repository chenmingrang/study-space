package factory_pattern.multiFactory;

public class YellowHuman implements Human{

	@Override
	public void getColor() {
		System.out.println("黄种人的肤色是黄色的");
	}

	@Override
	public void talk() {
		System.out.println("黄种人在说话");
	}

}
