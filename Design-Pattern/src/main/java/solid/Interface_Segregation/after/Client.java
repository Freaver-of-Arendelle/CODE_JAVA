package solid.Interface_Segregation.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:19
 */
public class Client {
    public static void main(String[] args) {
        HeimaSafetyDoor door = new HeimaSafetyDoor();

        door.antiTheft();
        door.fireProof();
        door.waterProof();


        System.out.println("=======================");
        ItcastSafetyDoor door1 = new ItcastSafetyDoor();

        door1.antiTheft();
        door1.fireProof();
    }
}
