package pattern.structural.facade;

/**
 * @author Freaver
 * @date 4/27/2021 14:40
 */
public class SmartAppliancesFacade {
    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartAppliancesFacade() {
        this.light = new Light();
        this.tv = new TV();
        this.airCondition = new AirCondition();
    }

    public void on() {
        System.out.println("Get up...");
        light.on();
        tv.on();
        airCondition.on();
    }

    public void off() {
        System.out.println("Sleep...");
        light.off();
        tv.off();
        airCondition.off();
    }

    public void say(String msg) {
        if (msg.contains("on")) {
            on();
        } else if (msg.contains("off")) {
            off();
        } else {
            System.out.println("Can't understand what you say");
        }
    }
}
