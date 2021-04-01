package mod;

/**
 * @author Freaver
 */
public class CoffeeBrewer extends CoffeeAccessory {
    private String brewerModel;

    boolean waterSupply;
    /**
     * true means Pour-over; false means Automatic
     */

    private int cupsNumbers;

    public CoffeeBrewer(String code, String description, float price, int number, String brewerModel,
        boolean waterSupply, int cupsNumbers) {
        super(code, description, price, number);
        this.brewerModel = brewerModel;
        this.waterSupply = waterSupply;
        this.cupsNumbers = cupsNumbers;
    }

    public String getBrewerModel() {
        return brewerModel;
    }

    public void setBrewerModel(String brewerModel) {
        this.brewerModel = brewerModel;
    }

    public boolean isWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(boolean waterSupply) {
        this.waterSupply = waterSupply;
    }

    public int getCupsNumbers() {
        return cupsNumbers;
    }

    public void setCupsNumbers(int cupsNumbers) {
        this.cupsNumbers = cupsNumbers;
    }

    @Override public String toString() {
        return "CoffeeBrewer{" + super.toString();
    }

    public String allToString() {
        return "CoffeeBrewer{" + super.toString() + "brewerModel='" + brewerModel + '\'' + ", waterSupply="
            + waterSupply + ", cupsNumbers=" + cupsNumbers + '}';
    }
}
