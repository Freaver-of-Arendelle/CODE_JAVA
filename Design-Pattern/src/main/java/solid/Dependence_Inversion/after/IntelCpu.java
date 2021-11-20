package solid.Dependence_Inversion.after;

/**
 * @author Freaver
 * @date 4/27/2021 18:58
 */
public class IntelCpu implements Cpu{
    @Override
    public void run() {
        System.out.println("Use intel cpu");
    }
}
