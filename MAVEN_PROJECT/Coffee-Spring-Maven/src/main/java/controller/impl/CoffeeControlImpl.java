package controller.impl;

import controller.CoffeeControl;
import models.bean.Product;
import models.beanList.ProductList;
import service.CoffeeSer;
import service.impl.CoffeeSerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:41
 */
public class CoffeeControlImpl implements CoffeeControl {
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//    CoffeeSer coffeeSer = (CoffeeSer)applicationContext.getBean("CoffeeSer");
    CoffeeSer coffeeSer = new CoffeeSerImpl();
    Product product = new Product();
    ProductList productList = new ProductList();
    List<ProductList> list = new ArrayList<>();

    Scanner in = new Scanner(System.in);

    @Override public void showList() {
        System.out.println(product.toString());
    }

    @Override public void getProduct() {
        String name;
        String code;
        System.out.println("Please input the productName:");
        name = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(product.getProduct(name, code).toString());
    }

    @Override public void getCurrentOrder() {

    }

    @Override public void addProduct() {
        String name;
        String code;
        System.out.println("PLease input the productName:");
        name = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();

        switch (name) {
            case "Coffee" -> productList.setCoffeeList(code);
            case "CoffeeBrewer" -> productList.setCoffeeBrewerList(code);
            case "CoffeeAccessory" -> productList.setCoffeeAccessoryList(code);
            default -> System.err.println("NullFixedName");
        }
    }

    @Override public void removeProduct() {
        String name;
        String code;
        System.out.println("PLease input the productName:");
        name = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        switch (name) {
            case "Coffee" -> productList.deleteCoffeeList(code);
            case "CoffeeBrewer" -> productList.deleteCoffeeBrewerList(code);
            case "CoffeeAccessory" -> productList.deleteCoffeeAccessoryList(code);
        }
    }

    @Override public void registerCurrentOrder() {
        list.add(productList);
        productList.clear();

    }

    @Override public void displaySales() {
        for (ProductList c : list) {
            c.showCurrentOrder();
        }
    }
}

