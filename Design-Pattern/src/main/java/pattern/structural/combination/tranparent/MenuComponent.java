package pattern.structural.combination.tranparent;

/**
 * @author Freaver
 * @date 4/28/2021 23:16
 */
public abstract class MenuComponent {
    protected String name;
    protected int level;

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw  new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
