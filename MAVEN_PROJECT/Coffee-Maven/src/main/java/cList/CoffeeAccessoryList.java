package cList;

import mod.CoffeeAccessory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Freaver
 */
public class CoffeeAccessoryList {
    List<CoffeeAccessory> coffeeAccessoryList = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, Integer> index = new HashMap<>();

    public CoffeeAccessoryList() {
        this.coffeeAccessoryList.add(new CoffeeAccessory("A001", "almond Flavored Syrup", 9.00f, 0));
        this.coffeeAccessoryList.add(new CoffeeAccessory("A002", "Irish Creme Flavored Syrup", 9.00f, 0));
        this.coffeeAccessoryList.add(new CoffeeAccessory("A005", "Gourmet Coffee Cookies", 12.00f, 0));
        this.coffeeAccessoryList.add(new CoffeeAccessory("A007", "Gourmet Coffee Ceramic Mug", 8.00f, 0));
        this.coffeeAccessoryList.add(new CoffeeAccessory("A009", "Gourmet Coffee 36 Cup Filters", 45.00f, 0));
        this.map.put("A001", 0);
        this.map.put("A002", 0);
        this.map.put("A005", 0);
        this.map.put("A007", 0);
        this.map.put("A009", 0);
        this.index.put("A001", 0);
        this.index.put("A002", 1);
        this.index.put("A005", 2);
        this.index.put("A007", 3);
        this.index.put("A009", 4);
    }

    public void clear() {
        coffeeAccessoryList.clear();
    }

    public void printCurrentOrder() {
        for (CoffeeAccessory c : coffeeAccessoryList) {
            if (c.getNumber() != 0) {
                System.out.println(c.toString() + " number: " + c.getNumber());
            }
        }
    }

    public CoffeeAccessory getCoffeeAccessory(String code) {
        for (CoffeeAccessory c : coffeeAccessoryList) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public void setMap(HashMap<String, Integer> map) {
        this.map = map;
    }

    public List<CoffeeAccessory> getCoffeeAccessoryList() {
        return coffeeAccessoryList;
    }

    public void setCoffeeAccessoryList(List<CoffeeAccessory> coffeeAccessoryList) {
        this.coffeeAccessoryList = coffeeAccessoryList;
    }

    public void numberAdd(String code) {
        coffeeAccessoryList.get(index.get(code)).setNumber();
    }

    public void numberDelete(String code) {
        this.map.replace(code, 0);
        coffeeAccessoryList.get(index.get(code)).removeNumber();
    }

    @Override public String toString() {
        return "CoffeeAccessoryList{" + "coffeeAccessoryList=" + coffeeAccessoryList + '}';
    }

    public int getSize() {
        return coffeeAccessoryList.size();
    }
}
