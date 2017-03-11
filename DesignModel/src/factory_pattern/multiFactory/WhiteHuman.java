package factory_pattern.multiFactory;

public class WhiteHuman implements Human{

	@Override
	public void getColor() {
		System.out.println("白种人的肤色是白色的");
	}

	@Override
	public void talk() {
		System.out.println("白种人在说话");
	}

}
