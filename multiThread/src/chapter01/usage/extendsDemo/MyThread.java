package chapter01.usage.extendsDemo;

import java.util.Random;

public class MyThread extends Thread {
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				int time = new Random().nextInt(10) * 1000;
				Thread.sleep(time);
				System.out.println("run= "+Thread.currentThread().getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
