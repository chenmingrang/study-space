package builder_pattern.carBuilder;

import java.util.ArrayList;

import org.junit.Test;

public class TestCase {
	@Test
	public void benzTest() {
		ArrayList<String> sequence=new ArrayList<String>();
		sequence.add("engineBoom");
		sequence.add("start");
		sequence.add("stop");
		BenzBuilder benzBuilder=new BenzBuilder();
		benzBuilder.setSequence(sequence);
		BenzModel benz=(BenzModel) benzBuilder.getCarModel();
		benz.run();
		
		BMWBuilder bmwBuilder=new BMWBuilder();
		bmwBuilder.setSequence(sequence);
		BMWModel BMW=(BMWModel) bmwBuilder.getCarModel();
		BMW.run();
	}
}
