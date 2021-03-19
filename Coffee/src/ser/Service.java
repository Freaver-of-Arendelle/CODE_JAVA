package ser;

import mod.Product;

import java.util.Scanner;

/**
 * @author Freaver
 */
public class Service {

    Product product = new Product();

    public void getProduct() {
        Scanner in = new Scanner(System.in);
        String productName;
        String code;
        System.out.println("Please input the productName:");
        productName = in.nextLine();
        System.out.println("Please input the code:");
        code = in.nextLine();
        System.out.println(product.getProduct(productName, code).toString());
    }


    public void showList() {
        System.out.println(product.toString());
    }




    
}
