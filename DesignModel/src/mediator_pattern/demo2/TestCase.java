package mediator_pattern.demo2;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		AbstractMediator mediator=new Mediator();
		System.out.println("=======采购人员采购电脑=======");
		Purchase purchase=new Purchase(mediator);
		purchase.buyIBMcomputer(100);
		System.out.println("=======销售人员销售电脑=======");
		Sale sale=new Sale(mediator);
		sale.sellIBMComputer(1);
		System.out.println("=======库房人员清理库存=======");
		Stock stock =new Stock(mediator);
		stock.clearStock();
	}
}
