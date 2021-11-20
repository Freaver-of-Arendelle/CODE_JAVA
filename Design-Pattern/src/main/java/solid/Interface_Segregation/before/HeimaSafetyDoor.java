package solid.Interface_Segregation.before;

import javax.xml.transform.Source;

/**
 * @author Freaver
 * @date 4/27/2021 19:14
 */
public class HeimaSafetyDoor implements SafetyDoor{
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
