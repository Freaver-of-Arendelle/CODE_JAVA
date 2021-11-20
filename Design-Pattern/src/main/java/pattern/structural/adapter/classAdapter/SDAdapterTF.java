package pattern.structural.adapter.classAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:08
 */
public class SDAdapterTF implements SDCard {

    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }


    @Override
    public String readSD() {
        System.out.println("pattern.structural.adapter raed tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("pattern.structural.adapter write tf card");
        tfCard.writeTF(msg);
    }
}
