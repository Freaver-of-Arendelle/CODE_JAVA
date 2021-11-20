package pattern.structural.adapter.classAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:04
 */
public class SDCardImpl implements SDCard {
    @Override
    public String readSD() {
        return "sd card read a msg: hello world SD";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("sd card write msg: " + msg);
    }
}
