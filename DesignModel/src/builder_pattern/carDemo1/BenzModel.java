package builder_pattern.carDemo1;

public class BenzModel extends CarModel{

	@Override
	protected void start() {
		System.out.println("benz is started");
	}

	@Override
	protected void stop() {
		System.out.println("benz is stopped");
	}

	@Override
	protected void alarm() {
		System.out.println("benz is alarming");
	}

	@Override
	protected void engineBoom() {
		System.out.println("benz is enginBooming");
	}

}
