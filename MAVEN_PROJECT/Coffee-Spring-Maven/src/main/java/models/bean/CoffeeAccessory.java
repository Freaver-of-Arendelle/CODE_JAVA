package models.bean;

/**
 * @author Freaver
 */
public class CoffeeAccessory extends CoffeeSummary{
    protected String description;

    @Override public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number++;
    }

    public void removeNumber()
    {
        this.number = 0;
    }
    @Override public String getCode() {
        return code;
    }

    @Override public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override public float getPrice() {
        return price;
    }

    @Override public void setPrice(float price) {
        this.price = price;
    }

    public CoffeeAccessory(String code, String description, float price, int number) {
        super(code, price, number);
        this.description = description;
    }

    @Override
    public String toString() {
        return "coffeeAccessory{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
