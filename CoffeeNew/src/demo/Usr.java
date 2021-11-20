package demo;

import controller.CoffeeSales;
import controller.impl.CoffeeSalesImpl;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Freaver
 */
public class Usr {

    public static CoffeeSales coffeeSales = new CoffeeSalesImpl();

    public static void display() {
        System.out.println("1.Display the catalog\n");
        System.out.println("2.Display the product\n");
        System.out.println("3.Display the current order\n");
        System.out.println("4.Add a product to the current order\n");
        System.out.println("5.Remove a product from the current order\n");
        System.out.println("6.Register the sale fo the current order\n");
        System.out.println("7.Display the sales\n");
        System.out.println("8.ShowFileList\n");
        System.out.println("9.Exit\n");
    }

    public static void main(String[] args) {
        int choose = 0;
        do {
            display();
            Scanner in = new Scanner(System.in);
            try {
                choose = in.nextInt();
                switch (choose) {
                    case 1 -> coffeeSales.showList();
                    case 2 -> coffeeSales.getProduct();
                    case 3 -> coffeeSales.getCurrentOrder();
                    case 4 -> coffeeSales.addProduct();
                    case 5 -> coffeeSales.removeProduct();
                    case 6 -> coffeeSales.registerCurrentOrder();
                    case 7 -> coffeeSales.displaySales();
                    case 8 -> coffeeSales.showFileSales();
                    case 9 -> System.out.println("You are exited");
                    default -> System.err.println("Please input between 1 and 9");
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.err.println("Please input Integer");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        while (choose != 9);
    }
}
