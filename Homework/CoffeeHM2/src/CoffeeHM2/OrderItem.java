package CoffeeHM2;


public class OrderItem {
	private final Product product;
	private int quantity;
	
	public OrderItem(Product initialProduct, int initialQuantity) {
		super();
		this.product = initialProduct;
		this.quantity = initialQuantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int newQuantity) {
		this.quantity = newQuantity;
	}

	public Product getProduct() {
		return product;
	}
	
	public double getValue() {
		return this.product.getPrice()*this.quantity;
	}

	@Override
	public String toString() {
		return quantity + " " + product.getCode() + " " + product.getPrice();
	}



}
