package builder_pattern.carDemo2;

import java.util.ArrayList;

public class Director {
	private ArrayList<String> sequence = new ArrayList<String>();
	private BenzBuilder benzBuilder = new BenzBuilder();
	private BMWBuilder bmwBuilder = new BMWBuilder();

	public BenzModel getBenzAModel() {
		sequence.clear();
		sequence.add("start");
		sequence.add("stop");
		benzBuilder.setSequence(sequence);
		return (BenzModel) benzBuilder.getCarModel();
	}
	
	public BenzModel getBenzBModel() {
		sequence.clear();
		sequence.add("engineBoom");
		sequence.add("start");
		sequence.add("stop");
		benzBuilder.setSequence(sequence);
		return (BenzModel) benzBuilder.getCarModel();
	}
	
	public BMWModel getBmwCModel(){
		sequence.clear();
		sequence.add("engineBoom");
		sequence.add("start");
		sequence.add("stop");
		bmwBuilder.setSequence(sequence);
		return (BMWModel) bmwBuilder.getCarModel();
	}
	public BMWModel getBmwDModel(){
		sequence.clear();
		sequence.add("start");
		bmwBuilder.setSequence(sequence);
		return (BMWModel) bmwBuilder.getCarModel();
	}
}
