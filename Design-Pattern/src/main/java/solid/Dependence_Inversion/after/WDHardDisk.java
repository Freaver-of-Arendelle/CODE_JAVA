package solid.Dependence_Inversion.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:01
 */
public class WDHardDisk implements HardDisk{
    @Override
    public void save(String data) {
        System.out.println("Use WDHardDisk to save data: " + data);
    }

    @Override
    public String get() {
        System.out.println("Use WDHardDisk to get data");
        return "data";
    }
}
