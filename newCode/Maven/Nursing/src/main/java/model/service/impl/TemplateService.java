package model.service.impl;

import model.service.SerializationService;

/**
 * @author Freaver
 * @Time 07/13/2021 21:48
 * @Description TemplateService类，实现了SerializationService抽象类
 */
public class TemplateService extends SerializationService {

    private TemplateService() {
    }

    private volatile static TemplateService singleton;

    private static String path = "src/main/resources/data/template.dat";


    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return TemplateService
     */
    public static TemplateService getSingleton() {
        if (singleton == null) {
            synchronized (TemplateService.class) {
                if (singleton == null) {
                    singleton = new TemplateService();
                    setPath(path);
                }
            }
        }

        return singleton;
    }

    public static void setPath() {
        setPath(path);
    }

}
