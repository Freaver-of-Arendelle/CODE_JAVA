package CoffeeHM2;

import java.util.Objects;

public class Product {
	private String code;
	private String description;
	private double price;
	
	public  Product(String initialCode, 
					String initialDescription,
					double initialPrice) {
		code = initialCode;
		description = initialDescription;
		price = initialPrice;
		
	}
	
	public String getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPrice() {
		return price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) {
			return false;
		}
		Product proObj = (Product)obj;
		if(this == proObj) {
			return true;
		}
		if(proObj.code.equals(this.code)) {
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public String toString() {
		
		return code + "_" + description +"_" + price;
	}

	public static void main(String[] args) {
		Product a1 = new Product("001", "001", 2);
		Product a2 = new Product("001", "001", 2);
		if(a2.equals(a1)) {
			System.out.println("yes");
			System.out.println(a1.hashCode());
			System.out.println(a2.hashCode());
			System.out.println(a1);
			System.out.println(a2);
		}
	}

}
