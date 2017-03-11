package builder_pattern.carDemo2;

import org.junit.Test;

public class TestCase {
	@Test
	public void benzTest() {
		Director director=new Director();
		for(int i=0;i<1;i++){
			director.getBenzAModel().run();
		}
		System.out.println("==========");
		for(int i=0;i<1;i++){
			director.getBenzBModel().run();
		}
		System.out.println("==========");
		for(int i=0;i<1;i++){
			director.getBmwCModel().run();
		}
	}
}
