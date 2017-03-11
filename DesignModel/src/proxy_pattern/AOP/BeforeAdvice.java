package proxy_pattern.AOP;

public class BeforeAdvice implements IAdvice{

	@Override
	public void exec() {
		System.out.println("我前置处理方法，我被调用了！");
	}

}
