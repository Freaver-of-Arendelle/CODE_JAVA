package dao;

import model.Product;

import java.util.List;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:36
 */
public interface DiskIO {

    void add(List<Product> productList);


    void delete(String code);

    void modify();

    List<Product> find(String code);
}
