package factory_pattern.lazzyInitialization;

public abstract class Product {
	//公共业务逻辑
	public void doSomething(){
		System.out.println("我是延迟加载工厂模式");
	}
   //抽象方法
	public abstract void doOther();
}
