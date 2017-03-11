package template_method_pattern.demo1;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		AbstractClass class1=new ConcreteClass1();
		AbstractClass class2=new ConcreteClass2();
		//调用末班方法
		class1.templateMethod();
		class2.templateMethod();
	}
}
