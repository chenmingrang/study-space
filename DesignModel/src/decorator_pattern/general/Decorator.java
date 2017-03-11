package decorator_pattern.general;

/**
 * 装饰者
 * 
 * @date 2017-1-1
 * @author *_* 陈明让 *_*
 */
public abstract class Decorator extends Component{
	private Component component = null;

	//通过构造函数传递被修饰者
	public Decorator(Component _cComponent) {
		this.component = _cComponent;
	}
	
	//委托给被装饰者
	public void operate(){
		this.component.operate();
	}
}
