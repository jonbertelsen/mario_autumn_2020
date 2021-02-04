import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseMapper implements IDataMapper {
    @Override
    public void persistOrderList(List<Order> orderList) {

    }

    @Override
    public List<Order> readOrders() {
        return null;
    }

    @Override
    public List<Pizza> readPizzas() {
        List<Pizza> menuCard = new ArrayList<>();
        String sql = "select * from pizza";
        try (Connection con = ConnectionConfiguration.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);)  {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                int pizzaID = resultSet.getInt("pizza_id");
                String name = resultSet.getString("name");
                String ingredients = resultSet.getString("ingredients");
                int price = resultSet.getInt("price");
                menuCard.add(new Pizza(pizzaID, name, ingredients, price));
            }
        } catch (SQLException e) {
            System.out.println("Fejl i connection til database");
            e.printStackTrace();
        }
        return menuCard;
    }
}
