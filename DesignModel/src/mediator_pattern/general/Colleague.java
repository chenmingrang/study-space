package mediator_pattern.general;

public abstract class Colleague {
	protected Mediator mediator;
	public Colleague(Mediator _mediator){
		this.mediator=_mediator;
	}
}
