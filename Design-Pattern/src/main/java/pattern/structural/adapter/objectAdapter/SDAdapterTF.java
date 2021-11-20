package pattern.structural.adapter.objectAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:08
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{




    @Override
    public String readSD() {
        System.out.println("pattern.structural.adapter raed tf card");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("pattern.structural.adapter write tf card");
        writeTF(msg);
    }
}
