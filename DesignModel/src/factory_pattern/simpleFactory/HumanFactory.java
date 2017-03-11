package factory_pattern.simpleFactory;

public class HumanFactory extends AbstractHumanFactory {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Human> T createHuman(Class<T> c) {
		Human human = null;
		try {
			human = c.newInstance();
			// human=(T) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("造人错误！");
		}
		return (T) human;
	}
	
	//静态工厂
	@SuppressWarnings("unchecked")
	public static <T extends Human> T createMan(Class<T> c) {
		Human human = null;
		try {
			human = c.newInstance();
			// human=(T) Class.forName(c.getName()).newInstance();
		} catch (Exception e) {
			System.out.println("造人错误！");
		}
		return (T) human;
	}

	public static void main(String[] args) {
		AbstractHumanFactory factory=new HumanFactory();
		System.out.println("<=============黑人==============>");
		Human black=factory.createHuman(BlackHuman.class);
		black.getColor();
		black.talk();
		System.out.println("<=============白人==============>");
		Human white=factory.createHuman(WhiteHuman.class);
		white.getColor();
		white.talk();
		System.out.println("<=============黄种人==============>");
		Human yellow=factory.createHuman(YellowHuman.class);
		yellow.getColor();
		yellow.talk();
		System.out.println("<=============静态工厂产生黄种人==============>");
		yellow=HumanFactory.createMan(YellowHuman.class);
		yellow.getColor();
		yellow.talk();
	}
}
