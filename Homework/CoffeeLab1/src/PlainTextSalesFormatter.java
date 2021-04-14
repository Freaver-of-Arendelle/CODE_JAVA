

/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:46
 */
public class PlainTextSalesFormatter implements SalesFormatter {

    static SalesFormatter singletonInstance = new PlainTextSalesFormatter();

    @Override public String formatSales(Sales sales) {
        int number = sales.getNumberOfOrders();
        StringBuffer str = new StringBuffer(number + "\n\n");
        for (var c : sales) {
            for (var v : c) {
                Product product = v.getProduct();
                str.append(v.getQuantity() + " " + product.getCode() + " " + product.getPrice() + "\n");
            }
            str.append(c.getTotalCost() + "\n\n");
            //            System.out.println(str.toString());
        }

        return str.toString();
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return (PlainTextSalesFormatter)singletonInstance;
    }

    private PlainTextSalesFormatter() {

    }
}
