package pattern.behavioral.template;

/**
 * @author Freaver
 * @date 4/29/2021 13:36
 */
public class Client {
    public static void main(String[] args) {

        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();

        ConcreteClass_Caixin caiXin = new ConcreteClass_Caixin();

        caiXin.cookProcess();
    }
}
