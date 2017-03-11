package mediator_pattern.demo1;

import org.junit.Test;

public class TestCase {
	@Test
	public void test1() {
		System.out.println("====采购人员采购电脑====");
		Purchase purchase=new Purchase();
		purchase.buyIBMcomputer(100);
		System.out.println("====销售人员销售电脑====");
		Sale sale=new Sale();
		sale.sellIBMComputer(1);
		System.out.println("====库房管理人员清库处理====");
		Stock stock=new Stock();
		stock.clearStock();
	}
}