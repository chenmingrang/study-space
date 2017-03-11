package decorator_pattern.general;

/**
 * 最核心、最原始、最基本的接口或者抽象类的实现，需要被装饰
 * @date 2017-1-1
 * @author *_* 陈明让 *_*
 */
public class ConcreteComponent extends Component{

	@Override
	public void operate() {
		System.out.println("do something");
	}

}
