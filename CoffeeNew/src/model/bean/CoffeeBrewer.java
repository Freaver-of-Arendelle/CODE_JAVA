package model.bean;

/**
 * @author Freaver
 */
public class CoffeeBrewer extends Product {
    private String brewerModel;

    boolean waterSupply;
    /**
     * true means Pour-over; false means Automatic
     */

    private int cupNumbers;

    private CoffeeBrewer() {

    }

    public static final class Builder  {
        private String code;
        private String description;
        private float price;
        private int number;
        private String brewerModel;
        boolean waterSupply;
        private int cupNumbers;

        public Builder brewerModel(String brewerModel) {
            this.brewerModel = brewerModel;
            return this;
        }

        public Builder waterSupply(boolean waterSupply) {
            this.waterSupply = waterSupply;
            return this;
        }

        public Builder cupNumbers(int cupNumbers) {
            this.cupNumbers = cupNumbers;
            return this;
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder() {

        }

        public CoffeeBrewer build() {
            return new CoffeeBrewer(this);
        }

    }

    private CoffeeBrewer(Builder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.price = builder.price;
        this.number = builder.number;
        this.brewerModel = builder.brewerModel;
        this.waterSupply = builder.waterSupply;

    }


    public String getBrewerModel() {
        return brewerModel;
    }

    public boolean getWaterSupply() {
        return waterSupply;
    }

    public int getCupNumbers() {
        return cupNumbers;
    }

    @Override
    public String toString() {
        return "CoffeeBrewer{" +
                "brewerModel='" + brewerModel + '\'' +
                ", waterSupply=" + waterSupply +
                ", cupNumbers=" + cupNumbers +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
