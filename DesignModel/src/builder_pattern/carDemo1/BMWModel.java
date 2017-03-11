package builder_pattern.carDemo1;

public class BMWModel extends CarModel{

	@Override
	protected void start() {
		System.out.println("BMW is started");
	}

	@Override
	protected void stop() {
		System.out.println("BMW is stopped");
	}

	@Override
	protected void alarm() {
		System.out.println("BMW is alarming");
	}

	@Override
	protected void engineBoom() {
		System.out.println("BMW is enginBooming");
	}

}
