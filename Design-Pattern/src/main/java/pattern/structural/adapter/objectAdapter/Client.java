package pattern.structural.adapter.objectAdapter;

/**
 * @author Freaver
 * @date 4/25/2021 23:11
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        System.out.println(computer.readSD(new SDCardImpl()));

        System.out.println("================");

        SDAdapterTF adapter = new SDAdapterTF();
        System.out.println(computer.readSD(adapter));
    }
}
