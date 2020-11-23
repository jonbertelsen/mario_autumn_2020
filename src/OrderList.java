import java.util.*;

public class OrderList {

    public IDataMapper getDataMapper() {
        return dataMapper;
    }

    private IDataMapper dataMapper;
    private List<Order> orderList;

    public OrderList(IDataMapper dataMapper) {
        this.dataMapper = dataMapper;
        this.orderList = dataMapper.readOrders();
    }

    public void sortOrders() {
        Collections.sort(orderList);
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addOrder(Order order) {
           orderList.add(order);
    }

    public int getTotalNumberOfOrders() {
        return orderList.size();
    }

    public void showOrderList(Menucard menucard){
        for (Order order : orderList) {
            System.out.println(order.getOrderDetails(menucard));
        }
    }

    public void removeOrder(int orderNo){
        for (Order order : orderList) {
            if (order.getOrderNo() == orderNo){
                order.setRemoved(true);
                break;
            }
        }
    }

    public void persistOrderList(){
        dataMapper.persistOrderList(orderList);
    }

    public void readOrders(){
        orderList = dataMapper.readOrders();
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
