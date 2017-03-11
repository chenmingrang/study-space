package abstract_factory_pattern.humanDemo;


import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		System.out.println("<=======创建男性=======>");
		HumanFactory maleFactory=new MaleFactory();
		Human blackMale=maleFactory.createBlackHuman();
		blackMale.talk();
		blackMale.getColor();
		blackMale.getSex();
		Human yellowMale=maleFactory.createYellowHuman();
		yellowMale.talk();
		yellowMale.getColor();
		yellowMale.getSex();
		Human whiteMale=maleFactory.createWhiteHuman();
		whiteMale.talk();
		whiteMale.getColor();
		whiteMale.getSex();
		System.out.println("<=======创建女性========>");
		HumanFactory femaleFactory=new FemaleFactory();
		Human yellowFemale=femaleFactory.createYellowHuman();
		yellowFemale.talk();
		yellowFemale.getColor();
		yellowFemale.getSex();
	}
}
