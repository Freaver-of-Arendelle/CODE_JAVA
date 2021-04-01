package view;

import controller.CoffeeControl;
import controller.impl.CoffeeControlImpl;

import java.util.Scanner;

/**
 * @author Freaver
 */
public class Usr {


//    public static CoffeeControl sales = new CoffeeControlImpl();

    public static void display() {
        System.out.println("1.Display the catalog\n");
        System.out.println("2.Display the product\n");
        System.out.println("3.Display the current order\n");
        System.out.println("4.Add a product to the current order\n");
        System.out.println("5.Remove a product from the current order\n");
        System.out.println("6.Register the sale fo teh current order\n");
        System.out.println("7.Display the sales\n");
        System.out.println("8.Exit\n");
    }

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        CoffeeControl sales = (CoffeeControl)applicationContext.getBean("CoffeeControl");
        CoffeeControl sales = new CoffeeControlImpl();
        int choose;
        do {
            display();
            Scanner in = new Scanner(System.in);
            choose = in.nextInt();
            switch (choose) {
                case 1 -> sales.showList();
                case 2 -> sales.getProduct();
                case 3 -> sales.getCurrentOrder();
                case 4 -> sales.addProduct();
                case 5 -> sales.removeProduct();
                case 6 -> sales.registerCurrentOrder();
                case 7 -> sales.displaySales();
                default -> System.out.println("You are exited");
            }
        } while (choose != 8);
    }
}
