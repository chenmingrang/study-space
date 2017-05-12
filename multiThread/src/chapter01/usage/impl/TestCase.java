package chapter01.usage.impl;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		//实现接口可以继承，扩展性强
		Demo1 demo1 = new Demo1();
		Thread thread = new Thread(demo1);
		thread.start();
	}
	
	@Test
	public void test2(){
		AutoComputer computer = new AutoComputer("这是一台自动工作的电脑！！");
//		computer.run();
		Thread thread = new Thread(computer);
		thread.setName("testThread");
		thread.start();
	}
	
	public static void main(String[] args) {
		AutoComputer computer = new AutoComputer("这是一台自动工作的电脑！！");
//		computer.run();
		Thread thread = new Thread(computer);
		thread.setName("testThread");
		thread.start();
	}
}
