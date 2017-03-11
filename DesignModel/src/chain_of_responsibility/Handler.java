package chain_of_responsibility;

public abstract class Handler {
	public final static int FATHER_LEVEL_REQUEST = 1;
	public final static int HUSBAND_LEVEL_REQUEST = 2;
	public final static int SON_LEVEL_REQUEST = 3;
	//下一个处理者
	private int level = 0;
	private Handler nextHandler;
	
	public void setNextHandler(Handler handler){
		this.nextHandler = handler;
	}
	
	public Handler(int _level){
		this.level = _level;
	}
	
	public final void handleMessage(IWomen women){
		if(women.getType()==this.level){
			this.response(women);
		}else {
			if(this.nextHandler != null){
				this.nextHandler.handleMessage(women);
			}else {
				System.out.println("没有地方可以请示了，按照不同意！");
			}
		}
	}
	
	protected abstract void response(IWomen women);
}
