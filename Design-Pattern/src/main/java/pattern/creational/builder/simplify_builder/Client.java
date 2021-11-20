package pattern.creational.builder.simplify_builder;

/**
 * @author Freaver
 * @date 4/28/2021 23:02
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("Samsung")
                .memory("kingston")
                .motherboard("Lenovo")
                .build();

        System.out.println(phone);

    }
}

