package main;

/**
 * @Author: Freaver
 * @Date: 3/30/2021  11:21
 */
public class OrderItem {
    private int quantity;
    private Product product;
    private double value;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderItem(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        value = product.getPrice() * (double)quantity;
    }

    public Product getProduct() {
        return product;
    }

    public double getValue() {
        return value;
    }

    @Override public String toString() {
        return "OrderItem{" + "quantity=" + quantity + ", product=" + product + ", value=" + value + '}';
    }
}
