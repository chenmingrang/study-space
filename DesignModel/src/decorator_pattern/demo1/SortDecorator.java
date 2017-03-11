package decorator_pattern.demo1;

public class SortDecorator extends Decorator {
	public SortDecorator(SchoolReport _sc) {
		super(_sc);
	}

	private void reportSort(){
		System.out.println("我的排第38名。。。");
	}
	
	@Override
	public void report(){
		this.reportSort();
		super.report();
	}
}
