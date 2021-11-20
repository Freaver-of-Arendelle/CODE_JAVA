package model.dao;

import model.bean.Product;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Author: Freaver
 * @Date: 3/28/2021  14:18
 */
public interface DiskIO {
    void add(List<Product> productList) throws FileNotFoundException;
    void delete();
    List<Product> find();
    void modify();
    void show();
}
