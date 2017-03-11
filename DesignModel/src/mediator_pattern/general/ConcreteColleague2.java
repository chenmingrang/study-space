package mediator_pattern.general;

public class ConcreteColleague2 extends Colleague{

	public ConcreteColleague2(Mediator _mediator) {
		super(_mediator);
	}
	//自由方法self-method
	public void self_method2(){
		System.out.println("colleague1 self_method");
	}
	
	//依赖方法 dep-method
	public void dep_method2(){
		super.mediator.doSomething1();
	}
}
