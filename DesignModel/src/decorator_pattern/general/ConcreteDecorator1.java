package decorator_pattern.general;

public class ConcreteDecorator1 extends Decorator{

	//定义被修饰者
	public ConcreteDecorator1(Component _cComponent) {
		super(_cComponent);
	}

	//定义自己的修饰方法
	private void method1(){
		System.out.println("method1 修饰");
	}
	
	//重写父类的方法
	@Override
	public void operate(){
		this.method1();
		super.operate();
	}
}
