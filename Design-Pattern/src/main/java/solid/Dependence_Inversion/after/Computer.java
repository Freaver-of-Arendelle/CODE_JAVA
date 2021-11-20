package solid.Dependence_Inversion.after;

/**
 * @author Freaver
 * @date 4/27/2021 19:02
 */
public class Computer {

    private HardDisk hardDisk;
    private Cpu cpu;
    private Memory memory;

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void run() {
        System.out.println("Run computer...");
        String data = hardDisk.get();
        System.out.println("Get data from the disk: " + data);
        cpu.run();
        memory.save();
    }
}
