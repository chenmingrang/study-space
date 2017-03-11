package factory_pattern.multiFactory;

import org.junit.Test;

public class TestCase {
	@Test
	public void test() {
		System.out.println("<======白种人=========>");
		Human white=(new WhiteHumanFactory()).createHuman();
		white.getColor();
		white.talk();
		System.out.println("<======黑种人========>");
		Human black=(new BlackHumanFactory()).createHuman();
		black.getColor();
		black.talk();
	}
}
