package dao;

import models.bean.CoffeeSummary;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:36
 */
public interface DiskIO {

    void add(CoffeeSummary productList);


    void delete(String name, String code);

    void modify();

    CoffeeSummary find(String name, String code);
}
