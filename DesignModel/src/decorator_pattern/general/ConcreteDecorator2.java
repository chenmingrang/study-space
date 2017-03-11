package decorator_pattern.general;

public class ConcreteDecorator2 extends Decorator{

	//定义被修饰者
	public ConcreteDecorator2(Component _cComponent) {
		super(_cComponent);
	}

	//定义自己的修饰方法
	private void method2(){
		System.out.println("method2 修饰");
	}
	
	//重写父类的方法
	@Override
	public void operate(){
		this.method2();
		super.operate();
	}
}
