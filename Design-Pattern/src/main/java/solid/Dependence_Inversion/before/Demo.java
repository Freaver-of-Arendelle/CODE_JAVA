package solid.Dependence_Inversion.before;

/**
 * @author Freaver
 * @date 4/27/2021 15:27
 */
public class Demo {

    public static void main(String[] args) {
        WDHardDisk wdHardDisk = new WDHardDisk();
        IntelCpu intelCpu = new IntelCpu();
        KingstonMemory kingstonMemory = new KingstonMemory();

        Computer computer = new Computer();

        computer.setCpu(intelCpu);
        computer.setDisk(wdHardDisk);
        computer.setMemory(kingstonMemory);

        computer.run();
    }

}
