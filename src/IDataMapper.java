import java.util.List;

public interface IDataMapper {
    public void persistOrderList(List<Order> orderList);
    public List<Order> readOrders();
    public List<Pizza> readPizzas();
}
