package CoffeeHM2;



public class CoffeeBrewer extends Product {
	private final String model;
	private final String waterSupply;
	private final int numberOfCups;
	
	public CoffeeBrewer(String initialCode, 
			String initialDescription, 
			double initialPrice, 
			String initialModel,
			String initialWaterSupply, 
			int initialNumberOfCups) {
		super(initialCode, initialDescription, initialPrice);
		this.model = initialModel;
		this.waterSupply = initialWaterSupply;
		this.numberOfCups = initialNumberOfCups;
	}

	public String getModel() {
		return model;
	}

	public String getWaterSupply() {
		return waterSupply;
	}

	public int getNumberOfCups() {
		return numberOfCups;
	}

	@Override
	public String toString() {
		return super.toString()+"_"+model+"_"+waterSupply+"_"+numberOfCups;
	}


}