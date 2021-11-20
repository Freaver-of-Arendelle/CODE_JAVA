package pattern.behavioral.mediator;

/**
 * @author Freaver
 * @date 5/1/2021 22:15
 */
public class Client {
    public static void main(String[] args) {
        MediatorStructure mediatorStructure = new MediatorStructure();

        HouseOwner houseOwner = new HouseOwner("Zhang", mediatorStructure);

        Tenant tenant = new Tenant("Li", mediatorStructure);

        mediatorStructure.setHouseOwner(houseOwner);

        mediatorStructure.setTenant(tenant);

        tenant.contact("Need rent 3 rooms' house");

        houseOwner.contact("Here is a 3 rooms' house, do you want to rent");


    }
}
