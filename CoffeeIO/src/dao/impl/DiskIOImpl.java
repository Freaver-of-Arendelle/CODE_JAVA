package dao.impl;

import dao.DiskIO;
import model.Product;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:38
 */
public class DiskIOImpl implements DiskIO {

    static PrintWriter printWriter;

    {
        try {
            printWriter = new PrintWriter("CoffeeList.dat");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override public void add(List<Product> productList) {
        for (var c : productList) {
            printWriter.print(c + "|" );
        }
    }

    @Override public void delete(String code) {

    }

    @Override public void modify() {

    }

    @Override public List<Product> find(String code) {
        return null;
    }
}
