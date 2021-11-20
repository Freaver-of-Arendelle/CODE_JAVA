package controller.impl;

import controller.CoffeeSales;
import model.service.CoffeeSer;
import model.service.impl.CoffeeSerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  00:38
 */
public class CoffeeSalesImpl implements CoffeeSales {

    CoffeeSer coffeeSer = new CoffeeSerImpl();
    List<CoffeeSer> coffeeSerList = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    @Override
    public void getCurrentOrder() {
        coffeeSer.showCurrentList();
    }

    @Override
    public void addProduct() {
        System.out.println("Please input the code:");
        String code = in.nextLine();

        do {
            if ("C001".equals(code) || "C002".equals(code) || "C007".equals(code) ||
                    "C008".equals(code) || "B001".equals(code) || "B002".equals(code) ||
                    "B003".equals(code) || "B004".equals(code) || "B005".equals(code) ||
                    "A009".equals(code) || "A007".equals(code) || "A005".equals(code) ||
                    "A002".equals(code) || "A001".equals(code)) {
                coffeeSer.addProduct(code);
                break;
            } else {
                throw new IllegalArgumentException("Please input correct code");
            }
        } while (true);
    }

    @Override
    public void removeProduct() {
        System.out.println("Please input the code:");
        String code = in.nextLine();
        coffeeSer.removeProduct(code);
    }

    @Override
    public void registerCurrentOrder() {
        coffeeSerList.add(coffeeSer);
        coffeeSer.register();
        coffeeSer.clear();
    }

    @Override
    public void displaySales() {
        for (var c : coffeeSerList) {
            c.showCurrentList();
        }
    }

    @Override
    public void showList() {
        coffeeSer.showList();
    }

    @Override
    public void getProduct() {
        coffeeSer.getProduct();
    }

    @Override
    public void showFileSales() {
        coffeeSer.showFileList();
    }
}
