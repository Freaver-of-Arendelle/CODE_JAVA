package model.impl;

import model.Product;

/**
 * @author Freaver
 */
public class CoffeeAccessory extends Product {

    public CoffeeAccessory(String code, String description, float price, int number) {
        super(code, description, price, number);
    }

    @Override
    public String toString() {
        return "CoffeeAccessory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
