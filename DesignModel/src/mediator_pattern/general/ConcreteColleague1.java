package mediator_pattern.general;

public class ConcreteColleague1 extends Colleague{

	public ConcreteColleague1(Mediator _mediator) {
		super(_mediator);
	}
	//自由方法self-method
	public void self_method1(){
		System.out.println("colleague1 self_method");
	}
	
	//依赖方法 dep-method
	public void dep_method1(){
		super.mediator.doSomething1();
	}
}
