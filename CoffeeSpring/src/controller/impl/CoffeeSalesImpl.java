package controller.impl;

import ser.CoffeeSer;
import ser.impl.CoffeeSerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  00:38
 */
public class CoffeeSalesImpl implements controller.CoffeeSales {

    CoffeeSer coffeeSer = new CoffeeSerImpl();
    List<CoffeeSer> coffeeSerList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    @Override public void getCurrentOrder() {
        coffeeSer.showCurrentList();
    }

    @Override public void addProduct() {
        System.out.println("Please input the code:");
        String code = in.nextLine();
        coffeeSer.addProduct(code);

    }

    @Override public void removeProduct() {
        System.out.println("Please input the code:");
        String code = in.nextLine();
        coffeeSer.removeProduct(code);
    }

    @Override public void registerCurrentOrder() {
        coffeeSerList.add(coffeeSer);
        coffeeSer.clear();
    }

    @Override public void displaySales() {
        for (var c : coffeeSerList) {
            c.showCurrentList();
        }
    }

    @Override public void showList() {
        coffeeSer.showList();
    }

    @Override public void getProduct() {
        coffeeSer.getProduct();
    }
}
