package template_method_pattern.hummerDemo;

public abstract class HummerModel {
	protected abstract void start();

	protected abstract void stop();

	protected abstract void alarm();

	protected abstract void engineBoom();

	public final void run() {
		start();
		engineBoom();
		if (isAlarm()) {
			alarm();
		}
		stop();
	}

	//钩子方法（Hook Method）
	protected boolean isAlarm() {
		return true;
	}
}
