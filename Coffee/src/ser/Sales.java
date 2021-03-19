package ser;

import cList.ProductList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/**
 * @author Freaver
 */
public class Sales
{
    Scanner in = new Scanner(System.in);

    List<ProductList> sales = new ArrayList<>();

    ProductList currentOrder = new ProductList();

    public void getCurrentOrder()
    {
        currentOrder.showCurrentOrder();
    }

    public void addProduct()
    {
        String productName;
        String code;
        System.out.println("PLease input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();

        switch (productName)
        {
            case "Coffee" -> currentOrder.setCoffeeList(code);
            case "CoffeeBrewer" -> currentOrder.setCoffeeBrewerList(code);
            case "CoffeeAccessory" -> currentOrder.setCoffeeAccessoryList(code);
        }
    }

    public void removeProduct()
    {
        String productName;
        String code;
        System.out.println("PLease input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        switch (productName)
        {
            case "Coffee" -> currentOrder.deleteCoffeeList(code);
            case "CoffeeBrewer" -> currentOrder.deleteCoffeeBrewerList(code);
            case "CoffeeAccessory" -> currentOrder.deleteCoffeeAccessoryList(code);
        }
    }

    public void registerCurrentOrder()
    {
        sales.add(currentOrder);
        currentOrder.clear();
    }

    public void displaySales()
    {
        for (ProductList c : sales)
        {
            c.showCurrentOrder();
        }
    }

}

