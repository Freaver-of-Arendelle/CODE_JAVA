package solid.Dependence_Inversion.after;

/**
 * @author Freaver
 * @date 4/27/2021 18:59
 */
public class KingstonMemory implements Memory{
    @Override
    public void save() {
        System.out.println("Use kingston memory");
    }
}
