package ser;

import mod.Product;

import java.util.Scanner;

/**
 * @author Freaver
 */
public interface Service {

    Product PRODUCT = new Product();

    /**
     * gwtProduct
     */
    void getProduct();

    void getCurrentOrder();

    void addProduct();

    void removeProduct();

    void registerCurrentOrder();

    void displaySales();

    /**
     * showList
     */
    void showList();

}
