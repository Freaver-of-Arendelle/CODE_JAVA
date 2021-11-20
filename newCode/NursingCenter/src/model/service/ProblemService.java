package model.service;

/**
 * @author Freaver
 * @Time 07/13/2021 21:48
 * @Description ProblemService类，实现了SerializationService抽象类
 */
public class ProblemService extends SerializationService {

    private ProblemService() {
    }

    private volatile static ProblemService singleton;

    private static String path = "resources/data/problem.dat";



    /**
     * 双重检查锁的单例模式同时设置file路径
     *
     * @return ProblemService
     */
    public static ProblemService getSingleton() {
        if (singleton == null) {
            synchronized (ProblemService.class) {
                if (singleton == null) {
                    singleton = new ProblemService();
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
