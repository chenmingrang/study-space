package chain_of_responsibility;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		Random random = new Random();
		ArrayList<IWomen> arrayList = new ArrayList<IWomen>();
		for (int i = 0; i < 5; i++) {
			arrayList.add(new Women(random.nextInt(3)+1, "我要出去走走！"));
		}
		Handler father = new Father();
		Handler husband = new Husband();
		Handler son = new Son();
		//设置责任链
		father.setNextHandler(husband);
		husband.setNextHandler(son);
		for (IWomen iWomen : arrayList) {
			father.handleMessage(iWomen);
			System.out.println("=============================");
		}
	}
}
