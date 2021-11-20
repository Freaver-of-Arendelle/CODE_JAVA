package solid.Dependence_Inversion.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:04
 */
public class Demo {
    public static void main(String[] args) {

        HardDisk hardDisk = new WDHardDisk();
        Cpu cpu = new IntelCpu();
        KingstonMemory memory = new KingstonMemory();


        Computer computer = new Computer();

        computer.setCpu(cpu);
        computer.setHardDisk(hardDisk);
        computer.setMemory(memory);

        computer.run();


    }
}
