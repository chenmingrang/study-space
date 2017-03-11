package builder_pattern.carDemo2;

import java.util.ArrayList;

public abstract class CarBuilder {
	public abstract void setSequence(ArrayList<String> sequence);

	public abstract CarModel getCarModel();

}
