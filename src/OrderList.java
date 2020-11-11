import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderList {

    private List<Order> orderList;

    public OrderList() {
        this.orderList = new ArrayList<Order>();
    }

    public void sortOrders() {
        Collections.sort(orderList);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public int getTotalNumberOfOrders() {
        return orderList.size();
    }

    @Override
    public String toString() {
        String output = "";
        for (Order order : orderList) {
            output += order.toString() + "\n";
        }
        return output;
    }
}
