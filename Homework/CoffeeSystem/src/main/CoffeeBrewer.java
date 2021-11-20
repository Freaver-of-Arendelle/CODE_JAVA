/**
 * @Author: Freaver
 * @Date: 3/29/2021  18:36
 */
public class CoffeeBrewer extends Product{
    private String model;
    private String waterSupply;
    private int numberOfCups;

    public String getModel() {
        return model;
    }

    public CoffeeBrewer(String code, String description, double price, String model, String waterSupply,
        int numberOfCups) {
        super(code, description, price);
        this.model = model;
        this.waterSupply = waterSupply;
        this.numberOfCups = numberOfCups;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    @Override public String toString() {
        return super.getCode() + "_" + super.getDescription() + "_" + super.getPrice() + "_"
            + model + "_" + waterSupply + "_" + numberOfCups;
    }
}
