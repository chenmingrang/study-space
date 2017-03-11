package abstract_factory_pattern.productDemo;

public class Creator2 extends AbstractCreator{

	@Override
	public AbstractProductA createAbstractProductA() {
		return new ProductA2();
	}

	@Override
	public AbstractProductB createAbstractProductB() {
		return new ProductB2();
	}


}
