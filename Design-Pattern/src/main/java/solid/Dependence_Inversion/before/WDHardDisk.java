package solid.Dependence_Inversion.before;

/**
 * @author Freaver
 * @date 4/27/2021 15:19
 */
public class WDHardDisk {

    public void save(String data) {
        System.out.println("Use WDHardDisk storage data: " + data);
    }

    public String get() {
        System.out.println("Use WDHardDisk get data");
        return "Data";
    }
}
