package solid.Interface_Segregation.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:18
 */
public class HeimaSafetyDoor implements AntiTheft, FireProof, WaterProof{
    @Override
    public void antiTheft() {
        System.out.println("anti");
    }

    @Override
    public void fireProof() {
        System.out.println("fireProof");
    }

    @Override
    public void waterProof() {
        System.out.println("waterProof");
    }
}
