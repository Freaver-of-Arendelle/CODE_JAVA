package CoffeeHM2;

import java.util.ArrayList;
import java.util.Iterator;

public class Sales implements Iterable<Order>{
	ArrayList<Order> orders;
	
	public Sales() {
		this.orders = new ArrayList<Order>();
	}
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	@Override public Iterator<Order> iterator(){
		return orders.iterator();
	}
	
	public int getNumberOfOrders() {
		return orders.size();
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
