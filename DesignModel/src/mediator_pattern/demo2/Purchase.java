package mediator_pattern.demo2;

public class Purchase extends AbstractColleague{
	public Purchase(AbstractMediator _mMediator) {
		super(_mMediator);
	}

	public void buyIBMcomputer(int number) {
		super.mediator.execute("purchase.buy", number);
	}
	
	public void refuseBuyIBM(){
		System.err.println("不再采购IBM的电脑");
	}
}
