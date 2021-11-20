package main;

/**
 * @Author: Freaver
 * @Date: 3/30/2021  11:18
 */
public class CoffeeBrewer extends Product{
    private String model;
    private String waterSupply;
    private int numberOfCups;

    public CoffeeBrewer(String code, String description, double price, String model, String waterSupply,
        int numberOfCups) {
        super(code, description, price);
        this.model = model;
        this.waterSupply = waterSupply;
        this.numberOfCups = numberOfCups;
    }

    public String getModel() {
        return model;
    }

    public String getWaterSupply() {
        return waterSupply;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    @Override public String toString() {
        return "CoffeeBrewer{" + "model='" + model + '\'' + ", waterSupply='" + waterSupply + '\'' + ", numberOfCups="
            + numberOfCups + '}';
    }
}
