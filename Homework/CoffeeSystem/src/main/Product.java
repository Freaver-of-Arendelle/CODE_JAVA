

/**
 * @Author: Freaver
 * @Date: 3/29/2021  18:36
 */
public class Product {
    private String code;
    private String description;
    private double price;

    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
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

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product)o;
        return getCode().equals(product.getCode());
    }

    @Override public String toString() {
        return code + "_" + description + "_" + price;
    }
}
