package solid.Open_Close;

/**
 * @author Freaver
 * @date 4/27/2021 14:59
 */
public class Client {

    public static void main(String[] args) {
        Input input = new Input();
        AbstractSkin skin = new DefaultSkin();
        input.setSkin(skin);
        input.display();
    }


}
