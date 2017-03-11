package mediator_pattern.demo2;

public class Mediator extends AbstractMediator{
	public Mediator(){
		super();
		System.out.println("meditor");
	}

	@Override
	public void execute(String str, Object... objects) {
		if(str.equals("purchase.buy")){
			this.buyComputer((Integer)objects[0]);
		}else if (str.equals("sale.selll")) {
			this.sellComputer((Integer)objects[0]);
		}else if (str.equals("sale.offsell")) {
			this.offsell();
		}else if (str.equals("sale.clear")) {
			this.clearStock();
		}
	}

	//采购电脑
	private void buyComputer(int number){
		int saleStatus=super.sale.getSaleStatus();
		if(saleStatus>80){
			System.out.println("采购IBM电脑："+number+"台");
			super.stock.increase(number);
		}else {
			int buyNumber=number/2;
			System.out.println("采购IBM电脑："+buyNumber+"台");
		}
	}
	
	//销售电脑
	private void sellComputer(int number){
		if(super.stock.getStockNumber()<number){
			super.purchase.buyIBMcomputer(number);
		}
		super.stock.decrease(number);
	}
	
	//打折销售电脑
	private void offsell(){
		System.out.println("折价销售IBM电脑"+stock.getStockNumber()+"台");
	}
	
	private void clearStock(){
		super.sale.offSale();
		super.purchase.refuseBuyIBM();
	}
}
