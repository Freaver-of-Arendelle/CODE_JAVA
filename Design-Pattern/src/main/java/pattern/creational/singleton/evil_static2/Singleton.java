package pattern.creational.singleton.evil_static2;

/**
 * @author Freaver
 * @date 4/27/2021 21:50
 */
public class Singleton {
    private Singleton() {};

    private static Singleton INSTANCE = null;

    static {
        INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
