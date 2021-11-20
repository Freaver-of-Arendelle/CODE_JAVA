package model;

/**
 * @author Freaver
 */
public class CoffeeAccessory implements Product{
    protected String code;
    protected String description;
    protected float price;
    protected int number;

    @Override public int getNumber() {
        return number;
    }

    @Override public void addNumber() {
        this.number++;
    }

    @Override public void removeNumber()
    {
        this.number = 0;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CoffeeAccessory(String code, String description, float price, int number) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.number = number;
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
