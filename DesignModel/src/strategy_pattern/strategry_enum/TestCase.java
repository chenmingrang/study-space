package strategy_pattern.strategry_enum;

import java.util.Arrays;

public class TestCase {
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println("输入的参数为："+Arrays.toString(args));
		System.out.println("执行结果为："+a+"+"+b+"="+Calculator.ADD.exec(a, b));
		System.out.println("执行结果为："+a+"-"+b+"="+Calculator.SUB.exec(a, b));
		System.out.println(Calculator.ADD.getValue());
	}
}
