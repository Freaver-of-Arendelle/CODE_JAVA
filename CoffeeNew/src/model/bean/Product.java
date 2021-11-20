package model.bean;

import java.io.Serializable;

/**
 * @Author: Freaver
 * @Date: 3/27/2021  23:44
 */
public abstract class Product implements Serializable {


    protected String code;
    protected String description;
    protected float price;
    protected int number;


    public int getNumber() {
        return number;
    }

    public void addNumber() {
        number++;
    }

    public void removeNumber() {
        number = 0;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }




}
