/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:46
 */
public class HTMLSalesFormatter implements SalesFormatter {
    static SalesFormatter singletonInstance = new HTMLSalesFormatter();

    @Override public String formatSales(Sales sales) {
        System.out.println();
        StringBuffer stringBuffer = new StringBuffer("");
        for (var c : sales) {
            int code = 1;
            int quantity = 1;
            int price = 1;
            stringBuffer.append("<hr>\n\t<h4>Total = " + c.getTotalCost() + "</h4>\n");
            for (var v : c) {
                Product product = v.getProduct();
                stringBuffer.append("\t<p>\n\t\t<b>code" + code++ + ":</b> " + product.getCode() + "<br>\n\t\t");
                stringBuffer.append("<b>quantity" + quantity++ + ":</b> " + v.getQuantity() + "<br>\n\t\t");
                stringBuffer.append("<b>price" + price++ + ":</b> " + product.getPrice() + "\n\t" + "</p>\n");
            }
            stringBuffer.append("</hr>\n");
        }
        return stringBuffer.toString();
    }

    public static HTMLSalesFormatter getSingletonInstance() {
        return (HTMLSalesFormatter)singletonInstance;
    }

    private HTMLSalesFormatter() {
    }

}
