package models.bean;

import models.beanList.CoffeeAccessoryList;
import models.beanList.CoffeeBrewerList;
import models.beanList.CoffeeList;

/**
 * @author Freaver
 */
public class Product {
    private final CoffeeList coffeeList = new CoffeeList();
    private final CoffeeBrewerList coffeeBrewerList = new CoffeeBrewerList();
    private final CoffeeAccessoryList coffeeAccessoryList = new CoffeeAccessoryList();

    @Override
    public String toString() {
        return "Product{" +
                "coffeeList=" + coffeeList +
                ", coffeeBrewerList=" + coffeeBrewerList +
                ", coffeeAccessoryList=" + coffeeAccessoryList +
                '}';
    }

    public String getProduct(String productName, String code) {
        return switch (productName) {
            case "Coffee" -> coffeeList.getCoffee(code).allToString();
            case "CoffeeBrewer" -> coffeeBrewerList.getCoffeeBrewer(code).allToString();
            case "CoffeeAccessory" -> coffeeAccessoryList.getCoffeeAccessory(code).toString();
            default -> null;
        };
    }
}


