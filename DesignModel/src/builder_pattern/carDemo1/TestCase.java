package builder_pattern.carDemo1;

import java.util.ArrayList;

import org.junit.Test;

public class TestCase {
	@Test
	public void benzTest() {
		BenzModel benz=new BenzModel();
		ArrayList<String> sequence=new ArrayList<String>();
		sequence.add("engineBoom");
		sequence.add("start");
		sequence.add("alarm");
		sequence.add("stop");
		benz.setSequence(sequence);
		benz.run();
	}
	
	@Test
	public void BMWTest(){
		BMWModel BMW=new BMWModel();
		ArrayList<String> sequence=new ArrayList<String>();
		sequence.add("engineBoom");
		sequence.add("alarm");
		sequence.add("start");
		sequence.add("stop");
		BMW.setSequence(sequence);
		BMW.run();
	}
}
