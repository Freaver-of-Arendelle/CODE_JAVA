import java.util.Iterator;

/**
 * @Author: Freaver
 * @Date: 4/1/2021  18:46
 */
public class HTMLSalesFormatter implements SalesFormatter {
    private static SalesFormatter singletonInstance = null;

    private HTMLSalesFormatter() {
    }

    public static HTMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new HTMLSalesFormatter();
        }
        return (HTMLSalesFormatter)singletonInstance;
    }

    @Override public String formatSales(Sales sales) {
        StringBuffer stringBuffer = new StringBuffer(
            "<html>" + "\n" + "  <body>" + "\n" + "    <center><h2>Orders</h2></center>" + "\n");
        Iterator iterator = sales.iterator();

        while (iterator.hasNext()) {
            Order order = (Order)iterator.next();
            stringBuffer.append("    <hr>" + "\n" + "    <h4>Total = " + order.getTotalCost() + "</h4>" + "\n");

            OrderItem orderItem;
            for (Iterator<OrderItem> iterator1 = order.iterator(); iterator1.hasNext(); stringBuffer.append("      <p>")
                .append("\n").append("        <b>code:</b> ").append(orderItem.getProduct().getCode())
                .append("<br>").append("\n").append("        <b>quantity:</b> ").append(orderItem.getQuantity())
                .append("<br>").append("\n").append("        <b>price:</b> ")
                .append(orderItem.getProduct().getPrice()).append("\n").append("      </p>").append("\n")) {
                orderItem = (OrderItem)iterator1.next();
            }
        }

        stringBuffer.append("  </body>" + "\n" + "</html>");
        return stringBuffer.toString();
    }



}
