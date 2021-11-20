package pattern.creational.singleton.reflection_destroy;

import java.lang.reflect.Constructor;

/**
 * @author Freaver
 * @date 4/27/2021 23:03
 */
public class Client {
    public static void main(String[] args) throws Exception {

        Class clazz = Singleton.class;

        Constructor cons =
                clazz.getDeclaredConstructor();

        cons.setAccessible(true);

        Singleton s1 = (Singleton) cons.newInstance();
        Singleton s2 = (Singleton) cons.newInstance();

        System.out.println(s1 == s2);

    }
}
