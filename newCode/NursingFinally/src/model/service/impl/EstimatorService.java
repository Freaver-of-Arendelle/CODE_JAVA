package model.service.impl;

import model.service.SerializationService;

/**
 * @author Freaver
 * @Time 07/13/2021 15:20
 * @Description StaffService类，实现了SerializationService抽象类
 */
public class EstimatorService extends SerializationService {

    private EstimatorService() {
    }

    private volatile static EstimatorService singleton;

    private static String path = "src/resources/data/estimator.dat";

    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return StaffService
     */
    public static EstimatorService getSingleton() {

        if (singleton == null) {
            synchronized (EstimatorService.class) {
                if (singleton == null) {
                    singleton = new EstimatorService();
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
