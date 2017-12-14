package strategy_pattern.demo;

import java.util.Arrays;

public class TestCase {
	public static void main(String[] args) {
		if(args==null || args.length==0){
			args = new String[3];
			args[0] = "11";
			args[1] = "+";
			args[2] = "8";
		}
		int a = Integer.parseInt(args[0]);
		String symbol = args[1];
		int b = Integer.parseInt(args[2]);
		System.out.println("输入的参数为："+Arrays.toString(args));
		Calculator c =new Calculator();
		System.out.println("执行结果为："+a+symbol+b+"="+c.exe(a, b, symbol));
	}
}
