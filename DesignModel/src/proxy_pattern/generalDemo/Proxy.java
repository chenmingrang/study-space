package proxy_pattern.generalDemo;

public class Proxy{
	// 要代理哪个类
	private Subject subject =null;

	public Proxy() {
	}

	// 通过构造函数传递代理者
	public Proxy(Subject subject) {
		this.subject=subject;
	}

	public void request() {
		before();
		subject.request();
		after();
	}

	private void before() {
		System.out.println("do something before");
	}

	private void after() {
		System.out.println("do something after");
	}

}
