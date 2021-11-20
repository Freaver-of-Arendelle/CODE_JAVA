package model.dao.impl;

import model.dao.DiskIO;
import model.bean.CoffeeAccessory;
import model.bean.Product;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  14:19
 */
public class DiskIOImpl implements DiskIO {
    private int number = 1;

    @Override
    public void add(List<Product> productList) {

        for (var c : productList) {
            if (c.getNumber() > 0) {
                writeData(c);
            }
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public List<Product> find() {
        return null;
    }

    @Override
    public void modify() {

    }

    @Override
    public void show() {
        List<String> stringList = readLineData();
        for (var c : stringList) {
            if (" ".equals(c)) {
                break;
            }
            String[] strings = c.split("_");
            Product product = new CoffeeAccessory.Builder()
                                .code(strings[0].strip())
                                .description(strings[1])
                                .price(Float.parseFloat(strings[2]))
                                .number(Integer.parseInt(strings[3].strip()))
                                .build();

            if (product.getCode().startsWith("C")) {
                System.out.print("Coffee: ");
                System.out.println(product.getDescription() + "_" + product.getPrice() + "_" + product.getNumber());
            } else if (product.getCode().startsWith("B")) {
                System.out.print("CoffeeBrewer: ");
                System.out.println(product.getDescription() + "_" + product.getPrice() + "_" + product.getNumber());
            } else {
                System.out.print("CoffeeAccessory: ");
                System.out.println(product.getDescription() + "_" + product.getPrice() + "_" + product.getNumber());
            }
        }
    }

    public void writeData(Product product) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("ProductList.dat", true), true,
                StandardCharsets.UTF_8)) {
            printWriter.print(
                    product.getCode() + "_" + product.getDescription() + "_" + product.getPrice() + "_" + product
                            .getNumber() + " | ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public List<String> readLineData() {
        List<String> list = null;
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new FileReader("ProductList.dat", StandardCharsets.UTF_8));
            String line = bufferedReader.readLine();
            list = Arrays.asList(line.split("\\|"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

}
