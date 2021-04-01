package models.bean;

/**
 * @Author: Freaver
 * @Date: 3/25/2021  22:27
 */
public class CoffeeSummary {
    protected String name;
    protected String code;
    protected float price;
    protected int number;

    public CoffeeSummary(String code, float price, int number) {
        this.code = code;
        this.price = price;
        this.number = number;
    }

    public CoffeeSummary(String name, String code, float price, int number) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    @Override public String toString() {
        return "CoffeeSummary{" + "code='" + code + '\'' + ", price=" + price + ", number=" + number + '}';
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }
}
