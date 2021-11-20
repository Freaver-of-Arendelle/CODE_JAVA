package solid.Interface_Segregation.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:19
 */
public class ItcastSafetyDoor implements AntiTheft, FireProof{
    @Override
    public void antiTheft() {
        System.out.println("anti");
    }

    @Override
    public void fireProof() {

        System.out.println("fireProof");
    }
}

