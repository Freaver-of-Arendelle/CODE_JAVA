package CoffeeHM2;

import java.util.ArrayList;
import java.util.Iterator;

public class Catalog implements Iterable<Product>{
	ArrayList<Product> products;
	
	public Catalog() {
		this.products = new ArrayList<Product>();
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	@Override public Iterator<Product> iterator(){
		return products.iterator();
	}
	
	public Product getProduct(String code) {
		for(Product i:products) {
			if(i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
	
	public int getNumberOfProducts() {
		return products.size();
	}
	
	
	

}