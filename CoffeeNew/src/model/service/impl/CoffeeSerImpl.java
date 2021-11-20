package model.service.impl;

import model.dao.DiskIO;
import model.dao.impl.IOObjectImpl;
import model.bean.Coffee;
import model.bean.CoffeeAccessory;
import model.bean.CoffeeBrewer;
import model.bean.Product;
import model.service.CoffeeSer;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Freaver
 */
public class CoffeeSerImpl implements CoffeeSer {
    private DiskIO diskIO = new IOObjectImpl();

    private List<Product> productList = new ArrayList<>();
    private Map<String, Integer> productIndex = new HashMap<>();

    public CoffeeSerImpl() {
        productList.add(new CoffeeAccessory.Builder()
                .code("A001")
                .description("almond Flavored Syrup")
                .price(9.00f)
                .number(0)
                .build());
        productList.add(new CoffeeAccessory.Builder()
                .code("A002")
                .description("Irish Creme Flavored Syrup")
                .price(9.00f)
                .number(0)
                .build());
        productList.add(new CoffeeAccessory.Builder()
                .code("A005")
                .description("Gourmet Coffee Cookies")
                .price(12.00f)
                .number(0)
                .build());
        productList.add(new CoffeeAccessory.Builder()
                .code("A007")
                .description("Gourmet Coffee Ceramic Mug")
                .price(8.00f)
                .number(0)
                .build());
        productList.add(new CoffeeAccessory.Builder()
                .code("A009")
                .description("Gourmet Coffee 36 Cup Filters")
                .price(45.00f)
                .number(0)
                .build());

        productList.add(new CoffeeBrewer.Builder()
                .code("B001")
                .description("Home Coffee Brewer")
                .price(150.00f)
                .number(0)
                .brewerModel("Brewer 100")
                .waterSupply(true)
                .cupNumbers(6)
                .build());

        productList.add(new CoffeeBrewer.Builder()
                .code("B002")
                .description("Coffee Brewer , 2 Warmers")
                .price(200.00f)
                .number(0)
                .brewerModel("Brewer 200")
                .waterSupply(true)
                .cupNumbers(12)
                .build());

        productList.add(new CoffeeBrewer.Builder()
                .code("B003")
                .description("Coffee Brewer, 3 Warmers")
                .price(280.00f)
                .number(0)
                .brewerModel("Brewer 210")
                .waterSupply(true)
                .cupNumbers(12)
                .build());

        productList.add(new CoffeeBrewer.Builder()
                .code("B004")
                .description("Commercial Brewer, 20 cups")
                .price(380.00f)
                .number(0)
                .brewerModel("Quick Coffee 100")
                .waterSupply(false)
                .cupNumbers(20)
                .build());

        productList.add(new CoffeeBrewer.Builder()
                .code("B005")
                .description("Commercial Brewer, 40 cups")
                .price(480.00f)
                .number(0)
                .brewerModel("Quick Coffee 200")
                .waterSupply(false)
                .cupNumbers(40)
                .build());

        productList.add(new Coffee.Builder()
                .code("C001")
                .description("Colombia, Whole, 1 lb")
                .price(17.99f)
                .originCountry("Colombia")
                .roast("Medium")
                .flavor("Rich and Hearty")
                .aroma("Rich")
                .acidity("Medium")
                .body("Full")
                .build());

        productList.add(new Coffee.Builder()
                .code("C002")
                .description("Colombia, Ground, 1 lb")
                .price(18.75f)
                .originCountry("Colombia")
                .roast("Medium")
                .flavor("Rich and Hearty")
                .aroma("Rich")
                .acidity("Medium")
                .body("Full")
                .build());

        productList.add(new Coffee.Builder()
                .code("C007")
                .description("Guatemala, Whole, 1 lb")
                .price(17.99f)
                .originCountry("Guatemala")
                .roast("Medium")
                .flavor("Rich and Complex")
                .aroma("Spicy")
                .acidity("Medium to high")
                .body("Medium to Full")
                .build());

        productList.add(new Coffee.Builder()
                .code("C008")
                .description("Guatemala, Ground, 1 lb")
                .price(18.75f)
                .originCountry("Guatemala")
                .roast("Medium")
                .flavor("Rich and complex")
                .aroma("Spicy")
                .acidity("Medium to high")
                .body("Medium to full")
                .build());



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


    @Override
    public void getProduct() {
        Scanner in = new Scanner(System.in);
        String code;
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(productList.get(productIndex.get(code)).toString());

    }

    @Override
    public void showList() {
        for (var c : productList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void register() {
        try {
            diskIO.add(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showFileList() {
        diskIO.show();
    }

    @Override
    public void showCurrentList() {
        for (var c : productList) {
            if (c.getNumber() > 0) {
                System.out.println(c.toString());
            }
        }
    }

    @Override
    public void addProduct(String code) {
        productList.get(productIndex.get(code)).addNumber();
    }

    @Override
    public void removeProduct(String code) {
        productList.get(productIndex.get(code)).removeNumber();

    }


    @Override
    public void clear() {
        for (var c : productList) {
            c.removeNumber();
        }
    }


}
