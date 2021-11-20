package model.service.impl;

import model.service.SerializationService;

/**
 * @author Freaver
 * @Time 07/13/2021 21:48
 * @Description PatientService类，实现了SerializationService抽象类
 */
public class PatientService extends SerializationService {

    private PatientService() {
    }

    private volatile static PatientService singleton;

    private static String path = "src/resources/data/patient.dat";



    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return PatientService
     */
    public static PatientService getSingleton() {
        if (singleton == null) {
            synchronized (PatientService.class) {
                if (singleton == null) {
                    singleton = new PatientService();
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
