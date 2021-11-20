package solid.Liskov_Substitution.before;

/**
 * @author Freaver
 * @date 4/27/2021 15:05
 */
public class Square extends Rectangle{

    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}
