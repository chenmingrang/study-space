package strategy_pattern.demo;

public class Calculator {
	private final static String ADD_SYMBOL = "+";
	private final static String SUB_SYMBOL = "-";

	public int exe(int a, int b, String symbol) {
		int result = 0;
		if (ADD_SYMBOL.equals(symbol)) {
			result = this.add(a, b);
		} else if (SUB_SYMBOL.equals(symbol)) {
			result = this.sub(a, b);
		}
		return result;
	}

	public int add(int a, int b) {
		return a + b;
	}

	public int sub(int a, int b) {
		return a - b;
	}
	
	public int exe2(int a, int b, String symbol){
		return symbol.equals(ADD_SYMBOL)?a+b:a-b;
	}
}