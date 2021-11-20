package model;

/**
 * @Author: Freaver
 * @Date: 3/27/2021  23:44
 */
public abstract class Product {
    protected String code;
    protected String description;
    protected float price;
    protected int number;

    public Product(String code, String description, float price, int number) {
        this.code = code;
        this.description = description;
        this.price = price;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addNumber() {
        this.number++;
    }

    public void removeNumber()
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


    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }
}
