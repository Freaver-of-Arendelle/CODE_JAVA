package pattern.structural.combination.safety;

/**
 * @author Freaver
 * @date 4/28/2021 23:16
 */
public abstract class MenuComponent {
    protected String name;
    protected int level;

    public String getName() {
        return name;
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
