package template_method_pattern.demo1;

public abstract class AbstractClass {
	protected abstract void doSomething1();

	protected abstract void doSomething2();

	//子类不能修改
	public final void templateMethod() {
		// 调用基本方法
		doSomething1();
		doSomething2();
	}
}
