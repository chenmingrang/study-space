package builder_pattern.carBuilder;

import java.util.ArrayList;

public abstract class CarBuilder {
	public abstract void setSequence(ArrayList<String> sequence);

	public abstract CarModel getCarModel();

}
