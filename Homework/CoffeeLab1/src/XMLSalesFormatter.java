/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:47
 */
public class XMLSalesFormatter implements SalesFormatter {

    static SalesFormatter singletonInstance = new XMLSalesFormatter();

    static public XMLSalesFormatter getSingletonInstance() {
        return (XMLSalesFormatter)singletonInstance;
    }

    private XMLSalesFormatter() {
    }

    @Override public String formatSales(Sales sales) {
        StringBuffer stringBuffer = new StringBuffer("<Sales>\n");
        for (var c : sales) {
            stringBuffer.append("\t<Order total=" + c.getTotalCost() + ">\n");
            int i = 1;
            for (var v : c) {
                stringBuffer.append("\t\t<OrderItem quantity=" + v.getQuantity() + "\n");
                stringBuffer.append("\t\tprice=" + v.getProduct().getPrice() + ">code" + i++ + "</OrderItem>\n");
            }
            stringBuffer.append("\t</Order>\n");
        }
        stringBuffer.append("</Sales>");
        return stringBuffer.toString();
    }

}
