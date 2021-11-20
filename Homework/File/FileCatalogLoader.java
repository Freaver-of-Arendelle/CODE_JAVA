import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @Author: Freaver
 * @Date: 4/7/2021  23:12
 */
public class FileCatalogLoader implements CatalogLoader {
    @Override
    public Catalog loadCatalog(String fileName)
            throws FileNotFoundException, DataFormatException {
        File file = new File("C:\\Users\\Freaver\\Desktop\\Homework\\Gourmet Coffee- File\\student-files\\" + fileName);
        Scanner in = new Scanner(new FileInputStream(file));
        Catalog catalog = new Catalog();

        while (in.hasNext()) {
            String str = in.nextLine();
            if (str.startsWith("Coffee")) {
                catalog.addProduct(readCoffee(str));
            } else if (str.startsWith("Brewer")) {
                catalog.addProduct(readCoffeeBrewer(str));
            } else if (str.startsWith("Product")) {
                catalog.addProduct(readProduct(str));
            }
        }


        return catalog;
    }


    private Product readProduct(String line) throws DataFormatException {
        StringTokenizer stringTokenizer = new StringTokenizer(line, "_");

        stringTokenizer.nextToken();
        String code = stringTokenizer.nextToken();
        String description = stringTokenizer.nextToken();
        double price = Double.parseDouble(stringTokenizer.nextToken());
        return new Product(code, description, price);
    }

    private Coffee readCoffee(String line) throws DataFormatException {
        StringTokenizer stringTokenizer = new StringTokenizer(line.strip(), "_");

        stringTokenizer.nextToken();
        String code = stringTokenizer.nextToken();
        String description = stringTokenizer.nextToken();
        double price = Double.parseDouble(stringTokenizer.nextToken());
        String origin = stringTokenizer.nextToken();
        String roast = stringTokenizer.nextToken();
        String flavor = stringTokenizer.nextToken();
        String aroma = stringTokenizer.nextToken();
        String acidity = stringTokenizer.nextToken();
        String body = stringTokenizer.nextToken();
        return new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);

    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
        StringTokenizer stringTokenizer = new StringTokenizer(line, "_");
        stringTokenizer.nextToken();
        String code = stringTokenizer.nextToken();
        String description = stringTokenizer.nextToken();
        double price = Double.parseDouble(stringTokenizer.nextToken());
        String model = stringTokenizer.nextToken();
        String waterSupply = stringTokenizer.nextToken();
        int numberOfCups = Integer.parseInt(stringTokenizer.nextToken());
        return new CoffeeBrewer(code, description, price, model, waterSupply, numberOfCups);
    }

}
