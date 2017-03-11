package builder_pattern.carDemo2;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder{
	private BMWModel BMW=new BMWModel();

	@Override
	public void setSequence(ArrayList<String> sequence) {
		BMW.setSequence(sequence);
	}

	@Override
	public CarModel getCarModel() {
		return BMW;
	}

}
