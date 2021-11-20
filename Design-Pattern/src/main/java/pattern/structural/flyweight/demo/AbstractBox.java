package pattern.structural.flyweight.demo;

/**
 * @author Freaver
 * @date 4/28/2021 23:25
 */
public abstract class AbstractBox {
    public abstract String getShape();

    public void display(String color) {
        System.out.println("Shape：" + this.getShape() + " Color：" + color);
    }
}
