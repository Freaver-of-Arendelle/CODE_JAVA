package pattern.structural.facade;

/**
 * @author Freaver
 * @date 4/27/2021 14:42
 */
public class Client {
    public static void main(String[] args) {
        SmartAppliancesFacade facade = new SmartAppliancesFacade();

        facade.say("on the family appliances");
        facade.say("off the family appliances");
    }
}
