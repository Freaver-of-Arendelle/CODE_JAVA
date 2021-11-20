package pattern.structural.adapter.classAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:05
 */
public class Computer {
    public String readSD(SDCard sdCard) {
        if(sdCard == null) {
            throw new NullPointerException("sd card is null");
        }
        return sdCard.readSD();
    }
}
