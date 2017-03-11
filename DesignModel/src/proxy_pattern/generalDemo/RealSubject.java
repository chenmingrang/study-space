package proxy_pattern.generalDemo;

public class RealSubject implements Subject {
	public void request() {
		System.out.println("realSubject do something");
	}
}
