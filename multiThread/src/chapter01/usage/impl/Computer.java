package chapter01.usage.impl;

public class Computer {
	public void work() throws InterruptedException{
		System.out.println("the computer is starting work ...");
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(2000);
		System.out.println("the computer is finished");
	}
}
