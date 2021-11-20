package pattern.structural.adapter.classAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:07
 */
public class TFCardImpl implements TFCard {
    @Override
    public String readTF() {
        return "tf card read msg: hello world tf card";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("tf card write a msg: " + msg);

    }
}
