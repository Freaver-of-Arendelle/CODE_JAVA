package cList;

import mod.CoffeeBrewer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Freaver
 */
public class CoffeeBrewerList extends CoffeeAccessoryList{
    List<CoffeeBrewer> coffeeBrewerList = new ArrayList<>();

    public CoffeeBrewerList() {
        this.coffeeBrewerList.add(new CoffeeBrewer("B001", "Home Coffee Brewer", 150.00f, 0, "Brewer 100", true, 6));
        this.coffeeBrewerList.add(new CoffeeBrewer("B002", "Coffee Brewer , 2 Warmers", 200.00f, 0, "Brewer 200", true, 12));
        this.coffeeBrewerList.add(new CoffeeBrewer("B003", "Coffee Brewer, 3 Warmers", 280.00f, 0, "Brewer 210", true, 12));
        this.coffeeBrewerList.add(new CoffeeBrewer("B004", "Commercial Brewer, 20 cups", 380.00f, 0, "Quick Coffee 100", false, 20));
        this.coffeeBrewerList.add(new CoffeeBrewer("B005", "Commercial Brewer, 40 cups", 480.00f, 0, "Quick Coffee 200", false, 40));
        this.map.put("B001", 0);
        this.map.put("B002", 0);
        this.map.put("B003", 0);
        this.map.put("B004", 0);
        this.map.put("B005", 0);
        this.index.put("B001", 0);
        this.index.put("B002", 1);
        this.index.put("B003", 2);
        this.index.put("B004", 3);
        this.index.put("B005", 4);

    }

    @Override
    public void clear()
    {
        coffeeBrewerList.clear();
    }

    @Override
    public void printCurrentOrder()
    {
        for (CoffeeBrewer c : coffeeBrewerList)
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
        coffeeBrewerList.get(index.get(code)).setNumber();
    }

    @Override
    public void numberDelete(String code)
    {
        this.map.replace(code, 0);
        coffeeBrewerList.get(index.get(code)).removeNumber();
    }

    public CoffeeBrewer getCoffeeBrewer(String code) {
        for (CoffeeBrewer c : coffeeBrewerList) {
            if (c.getCode().equals(code)) {
                return c;
            }
        }
        return null;
    }



    public List<CoffeeBrewer> getCoffeeBrewerList() {
        return coffeeBrewerList;
    }

    public void setCoffeeBrewerList(List<CoffeeBrewer> coffeeBrewerList) {
        this.coffeeBrewerList = coffeeBrewerList;
    }

    @Override
    public String toString() {
        return "CoffeeBrewerList{" +
                "coffeeBrewerList=" + coffeeBrewerList +
                '}';
    }

    @Override
    public int getSize() {
        return coffeeBrewerList.size();
    }
}
