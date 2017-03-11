package singleton_pattern;

import java.util.ArrayList;
import java.util.Random;

public class Emperor {
	private static int maxNumOfEmperor = 2;
	private static ArrayList<String> nameList = new ArrayList<String>();
	private static ArrayList<Emperor> empList = new ArrayList<Emperor>();
	private static int countNumOfEmp = 0;
	static {
		for (int i = 0; i < maxNumOfEmperor; i++) {
			empList.add(new Emperor("皇帝" + (i + 1)));
		}
	}

	private Emperor() {}
	private Emperor(String name) {
		nameList.add(name);
	}
	public static Emperor getInstance() {
		Random ran = new Random();
		countNumOfEmp = ran.nextInt(maxNumOfEmperor);
		return empList.get(countNumOfEmp);
	}
	
	public  void say(){
		System.out.println(nameList.get(countNumOfEmp));
	}
	
	public static void main(String[] args) {
		int ministerNum=5;
		for (int i = 0; i < ministerNum; i++) {
			Emperor emperor=Emperor.getInstance();
			System.out.print("第"+(i+1)+"个大臣参拜的是:");
			emperor.say();
		}
	}
}
