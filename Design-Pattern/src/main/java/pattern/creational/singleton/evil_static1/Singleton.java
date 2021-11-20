package pattern.creational.singleton.evil_static1;

/**
 * @author Freaver
 * @date 4/27/2021 21:50
 */
public class Singleton {
    private Singleton() {};

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
