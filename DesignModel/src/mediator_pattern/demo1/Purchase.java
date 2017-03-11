package mediator_pattern.demo1;

public class Purchase {
	public void buyIBMcomputer(int number) {
		Stock stock = new Stock();
		Sale sale = new Sale();
		int saleStatus = sale.getSaleStatus();
		if (saleStatus > 80) {
			System.out.println("采购IBM电脑：" + number + "台");
			stock.increase(number);
		} else {
			int buyNumber = number / 2;
			System.out.println("采购IBM电脑：" + buyNumber + "台");
		}
	}
	
	public void refuseBuyIBM(){
		System.err.println("不再采购IBM的电脑");
	}
}
