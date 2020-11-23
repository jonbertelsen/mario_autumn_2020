import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderList {

    private final String BEGIN = "BEGIN";
    private final String END = "END";
    private final String ORDERNO = "ORDERNO";
    private final String PIZZANO = "PIZZANO";
    private final String AMOUNT = "AMOUNT";
    private final String PICKUPTIME = "PICKUPTIME";
    private final String ORDERTIME = "ORDERTIME";
    private final String CUSTOMERNAME = "CUSTOMERNAME";
    private final String PHONE = "PHONE";
    private final String REMOVED = "REMOVED";

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

    public void saveOrderListToFile(String fileName){

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

    public void readOrdersFromFile(String fileName){
        String line = "";
        String token = "";
        Order order = null;

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
