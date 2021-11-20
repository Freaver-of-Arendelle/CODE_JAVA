import java.util.Iterator;

/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:47
 */
public class XMLSalesFormatter implements SalesFormatter {

    private static volatile SalesFormatter singletonInstance;

    private XMLSalesFormatter() {
    }

    static public XMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            synchronized (XMLSalesFormatter.class) {
                if (singletonInstance == null) {
                    singletonInstance = new XMLSalesFormatter();
                }
            }
        }
        return (XMLSalesFormatter) singletonInstance;
    }




    @Override
    public String formatSales(Sales sales) {
        StringBuffer stringBuffer = new StringBuffer("<Sales>" + "\n");

        for (Iterator<Order> iterator = sales.iterator(); iterator.hasNext(); stringBuffer.append("  </Order>")
                .append("\n")) {
            Order order = (Order) iterator.next();
            stringBuffer.append("  <Order total=\"" + order.getTotalCost() + "\">" + "\n");

            OrderItem orderItem;
            for (Iterator<OrderItem> it = order.iterator(); it.hasNext(); stringBuffer.append(
                    "    <OrderItem quantity=\"" + orderItem.getQuantity() + "\" price=\"" + orderItem.getProduct()
                            .getPrice() + "\">" + orderItem.getProduct().getCode() + "</OrderItem>" + "\n")) {
                orderItem = (OrderItem) it.next();
            }
        }

        stringBuffer.append("</Sales>");
        return stringBuffer.toString();
    }

}
