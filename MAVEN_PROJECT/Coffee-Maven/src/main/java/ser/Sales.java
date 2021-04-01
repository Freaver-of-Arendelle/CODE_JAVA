package ser;

import cList.ProductList;
import com.google.common.collect.BiMap;
import com.mysql.cj.protocol.a.MysqlBinaryValueDecoder;
import jdk.dynalink.beans.BeansLinker;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Freaver
 */
@SuppressWarnings("AlibabaServiceOrDaoClassShouldEndWithImpl") public class Sales implements Service {
    Scanner in = new Scanner(System.in);

    List<ProductList> sales = new ArrayList<>();

    ProductList currentOrder = new ProductList();

    @Override public void getCurrentOrder() {
        currentOrder.showCurrentOrder();
    }

    @Override public void addProduct() {
        String productName;
        String code;
        System.out.println("PLease input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();

        //noinspection AlibabaSwitchStatement
        switch (productName) {
            case "Coffee" -> currentOrder.setCoffeeList(code);
            case "CoffeeBrewer" -> currentOrder.setCoffeeBrewerList(code);
            case "CoffeeAccessory" -> currentOrder.setCoffeeAccessoryList(code);
            default -> throw new IllegalStateException("Unexpected value: " + productName);
        }
    }

    @Override public void removeProduct() {
        String productName;
        String code;
        System.out.println("PLease input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        //noinspection AlibabaSwitchStatement
        switch (productName) {
            case "Coffee" -> currentOrder.deleteCoffeeList(code);
            case "CoffeeBrewer" -> currentOrder.deleteCoffeeBrewerList(code);
            case "CoffeeAccessory" -> currentOrder.deleteCoffeeAccessoryList(code);
            default -> throw new IllegalStateException("Unexpected value: " + productName);
        }
    }

    @Override public void registerCurrentOrder() {
        sales.add(currentOrder);
        currentOrder.clear();
    }

    @Override public void displaySales() {
        for (ProductList c : sales) {
            c.showCurrentOrder();
        }
    }

    @Override public void getProduct() {
        Scanner in = new Scanner(System.in);
        String productName;
        String code;
        System.out.println("Please input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(PRODUCT.getProduct(productName, code).toString());
        System.out.println();
    }

    @Override public void showList() {
        System.out.println(PRODUCT.toString());

    }
}

