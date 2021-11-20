package model.service;

/**
 * @author Freaver
 * @date 07/12/2021 10:36
 * @description
 */
public class UserSecureService extends JSONService {

    private UserSecureService() {
    }

    private volatile static UserSecureService singleton;

    private static String path = "src/main/resources/data/userSecure.json";


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
