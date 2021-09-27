package pattern.builder;

import java.util.ArrayList;

public class BMWBuilder extends CarBuilder {
	private BMWModel benz = new BMWModel();
	@Override
	public CarModel getCarModel() {
		return this.benz;
	}
	@Override
	public void setSequence(ArrayList<String> sequence) {
		this.benz.setSequence(sequence);
	}

}
