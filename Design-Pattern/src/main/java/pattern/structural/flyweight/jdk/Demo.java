package pattern.structural.flyweight.jdk;

/**
 * @author Freaver
 * @date 4/28/2021 23:37
 */
public class Demo {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;

        System.out.println(i1 == i2);


        Integer i3 = 128;
        Integer i4 = 128;

        System.out.println(i3 == i4);
    }

}
