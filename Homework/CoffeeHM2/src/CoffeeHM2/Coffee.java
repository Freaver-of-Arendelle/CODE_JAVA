package CoffeeHM2;

public class Coffee extends Product {
	private final String origin;
	private final String roast;
	private final String flavor;
	private final String aroma;
	private final String acidity;
	private final String body;
	

	public Coffee(String initialCode, 
				String initialDescription, 
				double initialPrice, 
				String initialOrigin,
				String initialRoast, 
				String initialFlavor, 
				String initialAroma, 
				String initialAcidity, 
				String initialBody)
	{
		super(initialCode, initialDescription, initialPrice);
		this.origin = initialOrigin;
		this.roast = initialRoast;
		this.flavor = initialFlavor;
		this.aroma = initialAroma;
		this.acidity = initialAcidity;
		this.body = initialBody;
	}

	public String getOrigin() {
		return origin;
	}

	public String getRoast() {
		return roast;
	}

	public String getFlavor() {
		return flavor;
	}

	public String getAroma() {
		return aroma;
	}

	public String getAcidity() {
		return acidity;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return super.toString() + "_" +origin+"_"+roast+"_"+flavor+"_"+aroma+"_"+acidity+"_"+body;
	}

	public static void main(String[] args) {
		Coffee a1 = new Coffee(null, null, 0, null, null, null, null, null, null);
		System.out.println(a1);

	}

}
