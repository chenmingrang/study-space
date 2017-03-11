package builder_pattern.carDemo1;

import java.util.ArrayList;

public abstract class CarModel {
	private ArrayList<String> sequence = new ArrayList<String>();

	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	public final void run() {
		for (int i = 0; i < sequence.size(); i++) {
			String actionName=this.sequence.get(i);
			if (actionName.equals("start")) {
				start();
			}else if (actionName.equals("stop")) {
				stop();
			}else if (actionName.equals("alarm")) {
				alarm();
			}else if (actionName.equals("engineBoom")) {
				engineBoom();
			}
		}
	}
	
	public final void setSequence(ArrayList<String> sequence){
		this.sequence=sequence;
	}

}
