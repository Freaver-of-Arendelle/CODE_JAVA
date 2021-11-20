package solid.Liskov_Substitution.after;

/**
 * @author Freaver
 * @date 4/27/2021 15:15
 */
public class Demo {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();

        rectangle.setLength(20);
        rectangle.setWidth(10);

        resize(rectangle);

        print(rectangle);


    }

    public static void resize(Rectangle rectangle) {
        //判断宽如果比长小，进行扩宽的操作
        while(rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void print(Quadrilateral quadrilateral) {
        System.out.println(quadrilateral.getLength());
        System.out.println(quadrilateral.getWidth());
    }
}
