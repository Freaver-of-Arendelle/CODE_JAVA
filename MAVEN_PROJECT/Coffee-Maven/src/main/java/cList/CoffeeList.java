package cList;
import mod.Coffee;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 */
public class CoffeeList extends CoffeeAccessoryList{
    private List<Coffee> coffeeList = new ArrayList<>();
    public CoffeeList() {
        this.coffeeList.add(new Coffee("C001", "Colombia, Whole, 1 lb", 17.99f, 0, "Colombia", "Medium",  "Rich and Hearty", "Rich", "Medium", "Full"));
        this.coffeeList.add(new Coffee("C002", "Colombia, Ground, 1 lb", 18.75f, 0, "Colombia", "Medium",  "Rich and Hearty", "Rich", "Medium", "Full"));
        this.coffeeList.add(new Coffee("C007", "Guatemala, Whole, 1 lb", 17.99f, 0, "Guatemala", "Medium",  "Rich and Complex", "Spicy", "Medium to high", "Medium to full"));
        this.coffeeList.add(new Coffee("C008", "Guatemala, Ground, 1 lb", 18.75f, 0, "Guatemala", "Medium",  "Rich and complex", "Spicy", "Medium to high", "Medium to full"));
        this.map.put("C001", 0);
        this.map.put("C002", 0);
        this.map.put("C007", 0);
        this.map.put("C008", 0);
        this.index.put("C001", 0);
        this.index.put("C002", 1);
        this.index.put("C007", 2);
        this.index.put("C008", 3);
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    @Override
    public void clear()
    {
        coffeeList.clear();
    }

    @Override
    public void printCurrentOrder()
    {
        for (Coffee c : coffeeList)
        {
            if(c.getNumber() != 0)
            {
                System.out.println(c.toString() + " number: " + c.getNumber());
            }
        }
    }

    @Override
    public void numberAdd(String code)
    {
        coffeeList.get(index.get(code)).setNumber();
    }

    @Override
    public void numberDelete(String code)
    {
        this.map.replace(code, 0);
        coffeeList.get(index.get(code)).removeNumber();
    }

    public Coffee getCoffee(String code) {
        for (Coffee c : coffeeList) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }

    @Override
    public String toString() {
        return "CoffeeList{" +
            "coffeeList=" + coffeeList +
            '}';
    }


    @Override
    public int getSize() {
        return coffeeList.size();
    }
}
