package model.dao.impl;

import model.dao.DiskIO;
import model.bean.Product;

import java.io.*;
import java.util.List;

/**
 * @Author: Freaver
 * @Date: 4/10/2021  23:44
 */
public class IOObjectImpl implements DiskIO {

    @Override public void add(List<Product> productList)  {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ProductObject.dat", true))) {
            productList.removeIf(c -> c.getNumber() <= 0);
            oos.writeObject(productList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void delete() {

    }

    @Override public List<Product> find() {
        return null;
    }

    @Override public void modify() {

    }

    @Override public void show() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ProductObject.dat"))) {

            Object object = ois.readObject();

            List<Product> productList = (List<Product>) object;
            for (var c : productList) {
                System.out.println(c.toString());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
