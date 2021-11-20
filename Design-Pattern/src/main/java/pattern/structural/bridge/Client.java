package pattern.structural.bridge;

/**
 * @author Freaver
 * @date 4/27/2021 14:25
 */
public class Client {
    public static void main(String[] args) {
        OperatingSystemVersion os = new Mac(new RmvbFile());
        os.play("Frozen");
    }
}
