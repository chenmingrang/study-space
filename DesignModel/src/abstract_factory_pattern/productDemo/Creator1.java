package abstract_factory_pattern.productDemo;

public class Creator1 extends AbstractCreator{

	@Override
	public AbstractProductA createAbstractProductA() {
		return new ProductA1();
	}

	@Override
	public AbstractProductB createAbstractProductB() {
		return new ProductB1();
	}


}
