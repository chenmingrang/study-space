package chapter01.usage.fieldAndSecurity;

public class MyThread extends Thread {
	private int count = 100;

	@Override
	public synchronized void run() {
		count--;
		System.out.println("由" + this.currentThread().getName() + "计算，count="
				+ count);
	}
}
