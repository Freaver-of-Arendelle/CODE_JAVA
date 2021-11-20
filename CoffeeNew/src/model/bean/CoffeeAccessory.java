package model.bean;

/**
 * @author Freaver
 */
public class CoffeeAccessory extends Product  {

    protected CoffeeAccessory(Builder builder) {
        this.code = builder.code;
        this.description = builder.description;
        this.price = builder.price;
        this.number = builder.number;
    }

    protected CoffeeAccessory() {

    }

    public static class Builder {
        private String code;
        private String description;
        private float price;
        private int number;

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

        public CoffeeAccessory build() {
            return new CoffeeAccessory(this);
        }
    }

    @Override
    public String toString() {
        return "CoffeeAccessory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
