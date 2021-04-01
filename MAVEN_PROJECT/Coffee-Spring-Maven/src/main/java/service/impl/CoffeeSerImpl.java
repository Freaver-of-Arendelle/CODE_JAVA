package service.impl;

import dao.DiskIO;
import models.bean.CoffeeSummary;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CoffeeSer;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  09:31
 */
public class CoffeeSerImpl implements CoffeeSer {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    DiskIO diskIO = (DiskIO)applicationContext.getBean("DiskIO");
//    DiskIO diskIO = new DiskIOImpl();


    @Override public void registerOrder(CoffeeSummary currentProduct) {
        diskIO.add(currentProduct);
    }

    @Override public void deleteOrder(String name, String code) {
        diskIO.delete(name, code);
    }

    @Override public CoffeeSummary findOrder(String name ,String code) {
        return diskIO.find(name, code);
    }

    @Override public void modifyOrder() {

    }
}
