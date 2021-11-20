package solid.Dependence_Inversion.before;

/**
 * @author Freaver
 * @date 4/27/2021 15:25
 */
public class Computer {
    private WDHardDisk disk;
    private IntelCpu cpu;
    private KingstonMemory memory;

    public WDHardDisk getDisk() {
        return disk;
    }

    public void setDisk(WDHardDisk disk) {
        this.disk = disk;
    }

    public IntelCpu getCpu() {
        return cpu;
    }

    public void setCpu(IntelCpu cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    public void run() {
        System.out.println("Run the computer");
        String data = disk.get();
        System.out.println("Data get from the computer is: " + data);
        cpu.run();
        memory.save();
    }
}
