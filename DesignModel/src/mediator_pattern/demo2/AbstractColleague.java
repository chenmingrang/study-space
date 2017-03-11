package mediator_pattern.demo2;

public abstract class AbstractColleague {
	protected AbstractMediator mediator;
	public AbstractColleague(AbstractMediator _mMediator){
		this.mediator=_mMediator;
	}
}
