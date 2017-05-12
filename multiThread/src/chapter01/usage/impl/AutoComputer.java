package chapter01.usage.impl;

public class AutoComputer extends Computer implements Runnable {

	public AutoComputer(String desc) {
		System.out.println("this is a auto computer!");
	}

	@Override
	public void run() {
		try {
			this.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
