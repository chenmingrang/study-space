package chapter01.usage.fieldAndSecurity;


public class TestCase {
	public static void main(String[] args) {
		MyThread thread = new MyThread();
		for(int i=0;i<100;i++){
			Thread t = new Thread(thread,"线程"+i);
			t.start();
		}
	}
}
