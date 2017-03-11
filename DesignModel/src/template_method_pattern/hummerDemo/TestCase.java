package template_method_pattern.hummerDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1()throws Exception {
		System.out.println("<======H1========>");
		HummerH1Model H1=new HummerH1Model();
		System.out.println("H1型号的车是否需要喇叭，1-需要，0-不需要");
		String type=(new BufferedReader(new InputStreamReader(System.in))).readLine();
		if ("0".equals(type)) {
			H1.setAlarm(false);
		}
		H1.run();
		System.out.println("<======H2========>");
		HummerH2Model H2=new HummerH2Model();
		H2.run();
	}
}
