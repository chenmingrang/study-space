package chapter01.usage.extendsDemo;

public class MyThread2 extends Thread {
	public MyThread2(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		System.out.println("currentThread = "+Thread.currentThread().getName());
	}
}
