package main;

import java.util.Objects;

/**
 * @Author: Freaver
 * @Date: 3/30/2021  11:13
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
        return Double.compare(product.getPrice(), getPrice()) == 0 && Objects.equals(getCode(), product.getCode())
            && Objects.equals(getDescription(), product.getDescription());
    }

    @Override public String toString() {
        return "Product{" + "code='" + code + '\'' + ", description='" + description + '\'' + ", price=" + price + '}';
    }
}
