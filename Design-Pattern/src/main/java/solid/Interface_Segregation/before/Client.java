package solid.Interface_Segregation.before;

/**
 * @author Freaver
 * @date 4/27/2021 19:15
 */
public class Client {
    public static void main(String[] args) {
        HeimaSafetyDoor safetyDoor = new HeimaSafetyDoor();
        safetyDoor.antiTheft();
        safetyDoor.fireProof();
        safetyDoor.waterProof();
    }
}
