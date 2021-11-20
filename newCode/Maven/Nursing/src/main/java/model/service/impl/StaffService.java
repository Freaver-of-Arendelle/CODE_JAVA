package model.service.impl;

import model.service.SerializationService;

/**
 * @author Freaver
 * @Time 07/13/2021 15:20
 * @Description StaffService类，实现了SerializationService抽象类
 */
public class StaffService extends SerializationService {

    private StaffService() {
    }

    private volatile static StaffService singleton;

    private static String path = "src/main/resources/data/staff.dat";

    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return StaffService
     */
    public static StaffService getSingleton() {

        if (singleton == null) {
            synchronized (StaffService.class) {
                if (singleton == null) {
                    singleton = new StaffService();
                }
            }
        }
        setPath(path);
        return singleton;
    }

    public static void setPath() {
        setPath(path);
    }
}
