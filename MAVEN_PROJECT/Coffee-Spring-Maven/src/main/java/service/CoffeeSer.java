package service;

import models.bean.CoffeeSummary;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:29
 */
public interface CoffeeSer {
    void registerOrder(CoffeeSummary currentOrder);
    void deleteOrder(String name, String code);
    CoffeeSummary findOrder(String name ,String code);
    void modifyOrder();



}
