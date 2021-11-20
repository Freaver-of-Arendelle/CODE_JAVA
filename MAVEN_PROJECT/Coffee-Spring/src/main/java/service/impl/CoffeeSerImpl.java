package service.impl;

import dao.DiskIO;
import model.Product;
import service.CoffeeSer;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Freaver
 */
public class CoffeeSerImpl implements CoffeeSer {
    private DiskIO diskIO;

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productIndex = new HashMap<>();

    public CoffeeSerImpl(DiskIO diskIO){
        this.diskIO = diskIO;

    }

    public CoffeeSerImpl(DiskIO diskIO, List<Product> productList, Map<String, Integer> productIndex) {
        this.productIndex = productIndex;
        this.productList = productList;
        this.diskIO = diskIO;
    }

    @Override
    public void getProduct() {
        Scanner in = new Scanner(System.in);
        String code;
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(productList.get(productIndex.get(code)).toString());

    }

    @Override
    public void showList() {
        for (var c : productList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void register() {
        try {
            diskIO.add(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showFileList() {
        diskIO.show();
    }

    @Override
    public void showCurrentList() {
        for (var c : productList) {
            if (c.getNumber() > 0) {
                System.out.println(c.toString());
            }
        }
    }

    @Override
    public void addProduct(String code) {
        productList.get(productIndex.get(code)).addNumber();
    }

    @Override
    public void removeProduct(String code) {
        productList.get(productIndex.get(code)).removeNumber();

    }


    @Override
    public void clear() {
        for (var c : productList) {
            c.removeNumber();
        }
    }


}
