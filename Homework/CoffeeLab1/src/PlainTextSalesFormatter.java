

/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:46
 */
public class PlainTextSalesFormatter implements SalesFormatter {

    private static SalesFormatter singletonInstance = new PlainTextSalesFormatter();

    private PlainTextSalesFormatter() {
    }

    public static PlainTextSalesFormatter getSingletonInstance() {
        return (PlainTextSalesFormatter)singletonInstance;
    }


    @Override public String formatSales(Sales sales) {
            int i = 1;
            StringBuffer str = new StringBuffer("");
            for (var c : sales) {
                str.append("------------------------\n" + "Order " + i++ + "\n");
                for (var v : c) {
                    Product product = v.getProduct();
                    str.append(v.getQuantity() + " " + product.getCode() + " " + product.getPrice() + "\n");
                }
                str.append("Total = " + c.getTotalCost() + "\n");
            }

            return str.toString();
        }




}
