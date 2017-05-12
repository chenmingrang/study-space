package chapter01.usage.extendsDemo;

import java.util.Random;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1(){
		Run r = new Run();
		r.start();
		System.out.println("main thread");
	}
	
	@Test
	public void test2() throws InterruptedException{
		MyThread myThread = new MyThread();
		myThread.setName("myThread");
		myThread.start();
		for (int i = 0; i < 10; i++) {
			int time = new Random().nextInt(10) * 1000;
			Thread.sleep(time);
			System.out.println("main= "+Thread.currentThread().getName());
		}
	}
	
	@Test
	public void test3(){
		MyThread2 test1 = new MyThread2("t1");
		MyThread2 test2 = new MyThread2("t2");
		MyThread2 test3 = new MyThread2("t3");
		MyThread2 test4 = new MyThread2("t4");
		MyThread2 test5 = new MyThread2("t5");
		MyThread2 test6 = new MyThread2("t6");
		MyThread2 test7 = new MyThread2("t7");
		MyThread2 test8 = new MyThread2("t8");
		MyThread2 test9 = new MyThread2("t9");
		MyThread2 test10 = new MyThread2("t10");
		MyThread2 test11 = new MyThread2("t11");
		MyThread2 test12 = new MyThread2("t12");
		MyThread2 test13 = new MyThread2("t13");
		MyThread2 test14 = new MyThread2("t14");
		MyThread2 test15 = new MyThread2("t15");
		test1.start();
		test2.start();
		test3.start();
		test4.start();
		test5.start();
		test6.start();
		test7.start();
		test8.start();
		test9.start();
		test10.start();
		test11.start();
		test12.start();
		test13.start();
		test14.start();
		test15.start();
		//测试结果无序
	}
}
