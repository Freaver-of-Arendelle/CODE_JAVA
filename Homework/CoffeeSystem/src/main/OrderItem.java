/**
 * @Author: Freaver
 * @Date: 3/29/2021  18:36
 */
public class OrderItem {
    private int quantity;
    private Product product;
    private double value;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.value = product.getPrice() * (double)quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    @Override public String toString() {
        return quantity + " " + product.getCode() + " " + product.getPrice();
    }
}
