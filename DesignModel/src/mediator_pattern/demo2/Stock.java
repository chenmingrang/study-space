package mediator_pattern.demo2;

public class Stock extends AbstractColleague{
	public Stock(AbstractMediator _mMediator) {
		super(_mMediator);
	}

	private static int COMPUTER_NUMBER = 100;

	public void increase(int number) {
		COMPUTER_NUMBER += number;
		System.out.println("库存数量为："+COMPUTER_NUMBER);
	}
	
	public void decrease(int number){
		COMPUTER_NUMBER-=number;
		System.out.println("库存数量为："+COMPUTER_NUMBER);
	}
	
	public int getStockNumber(){
		return COMPUTER_NUMBER;
	}
	
	public void clearStock(){
		System.out.println("清理存货数量为："+COMPUTER_NUMBER);
		super.mediator.execute("stock.clear");
	}
}
