import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class FileDataMapper implements IDataMapper {

    private final String BEGIN = "BEGIN";
    private final String END = "END";
    private final String NO = "NO";
    private final String NAME = "NAME";
    private final String INGREDIENTS = "INGREDIENTS";
    private final String PRICE = "PRICE";

    private final String ORDERNO = "ORDERNO";
    private final String PIZZANO = "PIZZANO";
    private final String AMOUNT = "AMOUNT";
    private final String PICKUPTIME = "PICKUPTIME";
    private final String ORDERTIME = "ORDERTIME";
    private final String CUSTOMERNAME = "CUSTOMERNAME";
    private final String PHONE = "PHONE";
    private final String REMOVED = "REMOVED";

    @Override
    public void persistOrderList(List<Order> orderList) {
        String fileName = "orderlist.txt";
        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            for (Order order : orderList) {
                writer.println(BEGIN);
                writer.println(ORDERNO);
                writer.println(order.getOrderNo());
                writer.println(PIZZANO);
                writer.println(order.getPizzaNo());
                writer.println(AMOUNT);
                writer.println(order.getAmount());
                writer.println(PICKUPTIME);
                writer.println(order.getPickupTime());
                writer.println(ORDERTIME);
                writer.println(order.getOrderTime());
                writer.println(CUSTOMERNAME);
                writer.println(order.getCustomerName());
                writer.println(PHONE);
                writer.println(order.getPhone());
                writer.println(REMOVED);
                writer.println(order.isRemoved());
                writer.println(END);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> readOrders() {
        String line = "";
        String token = "";
        Order order = null;
        String fileName = "orderlist.txt";
        List<Order> orderList = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);

        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)){
            while(scanner.hasNext()){
                line = scanner.nextLine();
                switch(line){
                    case BEGIN:
                        order = new Order(); break;
                    case ORDERNO:
                        token = ORDERNO; break;
                    case PIZZANO:
                        token = PIZZANO; break;
                    case AMOUNT:
                        token = AMOUNT; break;
                    case PICKUPTIME:
                        token = PICKUPTIME; break;
                    case ORDERTIME:
                        token = ORDERTIME; break;
                    case CUSTOMERNAME:
                        token = CUSTOMERNAME; break;
                    case PHONE:
                        token = PHONE; break;
                    case REMOVED:
                        token = REMOVED; break;
                    case END:
                        if (order != null) {
                            orderList.add(order);
                        }
                        break;
                    default:
                        switch (token){
                            case ORDERNO:
                                order.setOrderNo(Integer.parseInt(line)); break;
                            case PIZZANO:
                                order.setPizzaNo(Integer.parseInt(line));
                                break;
                            case AMOUNT:
                                order.setAmount(Integer.parseInt(line));
                                break;
                            case PICKUPTIME:
                                order.setPickupTime(Integer.parseInt(line));
                                break;
                            case ORDERTIME:
                                Date javaDate = formatter.parse(line);
                                order.setOrderTime(javaDate); break;
                            case CUSTOMERNAME:
                                order.setCustomerName(line); break;
                            case PHONE:
                                order.setPhone(line); break;
                            case REMOVED:
                                order.setRemoved(Boolean.parseBoolean(line));
                        }
                }
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Pizza> readPizzas() {
            String fileName = "menucard.txt";
            String line = "";
            String token = "";
            Pizza pizza = null;
            List<Pizza> menuCard = new ArrayList<>();

            File file = new File(fileName);
            try (Scanner scanner = new Scanner(file)){
                while(scanner.hasNext()){
                    line = scanner.nextLine();
                    switch(line){
                        case BEGIN:
                            pizza = new Pizza(); break;
                        case NO:
                            token = NO; break;
                        case NAME:
                            token = NAME; break;
                        case INGREDIENTS:
                            token = INGREDIENTS; break;
                        case PRICE: token = PRICE; break;
                        case END:
                            if (pizza != null) {
                                menuCard.add(pizza);
                            }
                            break;
                        default:
                            switch (token){
                                case NO:
                                    pizza.setPizzaNo(Integer.parseInt(line)); break;
                                case NAME:
                                    pizza.setName(line);
                                    break;
                                case INGREDIENTS:
                                    pizza.setIngredients(line);
                                    break;
                                case PRICE:
                                    pizza.setPrice(Integer.parseInt(line));
                                    break;
                            }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return menuCard;
    }
}
