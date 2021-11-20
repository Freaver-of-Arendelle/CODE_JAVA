package solid.Liskov_Substitution.after;

/**
 * @author Freaver
 * @date 4/27/2021 15:14
 */
public class Square implements Quadrilateral {

    private double side;


    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
