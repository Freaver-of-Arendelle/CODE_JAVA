package ser.impl;

import dao.DiskIO;
import dao.impl.DiskIOImpl;
import mod.*;
import mod.impl.Coffee;
import mod.impl.CoffeeAccessory;
import mod.impl.CoffeeBrewer;
import ser.CoffeeSer;

import java.util.*;

/**
 * @author Freaver
 */
public class CoffeeSerImpl implements CoffeeSer {
    private DiskIO diskIO = new DiskIOImpl();

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productIndex = new HashMap<>();

    public CoffeeSerImpl() {
        productList.add(new CoffeeAccessory("A001", "almond Flavored Syrup", 9.00f, 0));
        productList.add(new CoffeeAccessory("A002", "Irish Creme Flavored Syrup", 9.00f, 0));
        productList.add(new CoffeeAccessory("A005", "Gourmet Coffee Cookies", 12.00f, 0));
        productList.add(new CoffeeAccessory("A007", "Gourmet Coffee Ceramic Mug", 8.00f, 0));
        productList.add(new CoffeeAccessory("A009", "Gourmet Coffee 36 Cup Filters", 45.00f, 0));

        productList.add(new CoffeeBrewer("B001", "Home Coffee Brewer", 150.00f, 0, "Brewer 100", true, 6));
        productList.add(new CoffeeBrewer("B002", "Coffee Brewer , 2 Warmers", 200.00f, 0, "Brewer 200", true, 12));
        productList.add(new CoffeeBrewer("B003", "Coffee Brewer, 3 Warmers", 280.00f, 0, "Brewer 210", true, 12));
        productList
            .add(new CoffeeBrewer("B004", "Commercial Brewer, 20 cups", 380.00f, 0, "Quick Coffee 100", false, 20));
        productList
            .add(new CoffeeBrewer("B005", "Commercial Brewer, 40 cups", 480.00f, 0, "Quick Coffee 200", false, 40));

        productList.add(
            new Coffee("C001", "Colombia, Whole, 1 lb", 17.99f, 0, "Colombia", "Medium", "Rich and Hearty", "Rich",
                "Medium", "Full"));
        productList.add(
            new Coffee("C002", "Colombia, Ground, 1 lb", 18.75f, 0, "Colombia", "Medium", "Rich and Hearty", "Rich",
                "Medium", "Full"));
        productList.add(
            new Coffee("C007", "Guatemala, Whole, 1 lb", 17.99f, 0, "Guatemala", "Medium", "Rich and Complex", "Spicy",
                "Medium to high", "Medium to full"));
        productList.add(
            new Coffee("C008", "Guatemala, Ground, 1 lb", 18.75f, 0, "Guatemala", "Medium", "Rich and complex", "Spicy",
                "Medium to high", "Medium to full"));

        productIndex.put("A001", 0);
        productIndex.put("A002", 1);
        productIndex.put("A005", 2);
        productIndex.put("A007", 3);
        productIndex.put("A009", 4);

        productIndex.put("B001", 5);
        productIndex.put("B002", 6);
        productIndex.put("B003", 7);
        productIndex.put("B004", 8);
        productIndex.put("B005", 9);

        productIndex.put("C001", 10);
        productIndex.put("C002", 11);
        productIndex.put("C007", 12);
        productIndex.put("C008", 13);

    }



    @Override public void getProduct() {
        Scanner in = new Scanner(System.in);
        String code;
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(productList.get(productIndex.get(code)).toString());

    }

    @Override public void showList() {
        for (var c : productList) {
            System.out.println(c.toString());
        }
    }

    @Override public void register() {
        diskIO.add(productList);
    }

    @Override public void showFileList() {
        diskIO.show();
    }

    @Override public void showCurrentList() {
        for (var c : productList) {
            if (c.getNumber() > 0) {
                System.out.println(c.toString());
            }
        }
    }

    @Override public void addProduct(String code) {
        productList.get(productIndex.get(code)).addNumber();
    }

    @Override public void removeProduct(String code) {
        productList.get(productIndex.get(code)).removeNumber();

    }


    @Override public void clear() {
        for (var c : productList) {
            c.removeNumber();
        }
    }



}
