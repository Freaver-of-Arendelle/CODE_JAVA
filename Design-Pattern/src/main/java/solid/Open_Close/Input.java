package solid.Open_Close;

/**
 * @author Freaver
 * @date 4/27/2021 14:58
 */
public class Input {
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}
