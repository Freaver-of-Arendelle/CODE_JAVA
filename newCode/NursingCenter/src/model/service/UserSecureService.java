package model.service;

/**
 * @author Freaver
 * @Time 07/12/2021 10:36
 * @Description UserSecureService类，实现了JSONService抽象类
 */
public class UserSecureService extends JSONService {

    private UserSecureService() {
    }

    private volatile static UserSecureService singleton;

    private static String path = "resources/data/userSecure.json";


    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return UserSecureService
     */
    public static UserSecureService getSingleton() {
        if (singleton == null) {
            synchronized (UserSecureService.class) {
                if (singleton == null) {
                    singleton = new UserSecureService();
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
