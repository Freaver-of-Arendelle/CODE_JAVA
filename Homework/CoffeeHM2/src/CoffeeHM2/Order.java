package CoffeeHM2;


import java.util.ArrayList;
import java.util.Iterator;

public class Order implements Iterable<OrderItem>{
	ArrayList<OrderItem> items;
	
	public Order() {
		this.items = new ArrayList<OrderItem>();
	}
	
	public void addItem(OrderItem orderItem) {
		this.items.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		this.items.remove(orderItem);
	}
	
	@Override public Iterator<OrderItem> iterator(){
		return items.iterator();
	}
	
	public OrderItem getItem(Product product) {
		for(OrderItem i:items) {
			if(i.getProduct().equals(product)) {
				return i;
			}
		}
		return null;
	}
	
	public int getNumberOfItems() {
		return items.size();
	}
	
	public double getTotalCost() {
		Double TotalCost = (double) 0;
		for(OrderItem i:items) {
			TotalCost += i.getValue() ;
		}
		return TotalCost;

	}
	
	

}
