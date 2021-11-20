package solid.Liskov_Substitution.before;

/**
 * @author Freaver
 * @date 4/27/2021 15:06
 */
public class Demo {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        rectangle.setLength(20);
        rectangle.setWidth(10);

        resize(rectangle);
        print(rectangle);

        System.out.println("=========================");

        Square square = new Square();

        square.setLength(10);

        resize(square);

        print(square);




    }

    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void print(Rectangle rectangle) {
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }
}
