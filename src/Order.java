import UI.Input;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private List<OrderLine> pizzas;
    private int pickupTime;
    private Date orderTime;
    private String customerName;
    private String phone;
    private boolean removed;

    public Order(int pickupTime, String customerName, String phone) {
        this.pizzas = new ArrayList<OrderLine>();
        this.pickupTime = pickupTime;
        this.customerName = customerName;
        this.phone = phone;
        this.orderTime = new Date();
        this.removed = false;
    }

    public void addPizza(Pizza pizza, int amount){
        pizzas.add(new OrderLine(pizza, amount));
    }

    public int getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(int pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {

        String allPizzas = "";
        for (OrderLine pizza : pizzas) {
            allPizzas = allPizzas + pizza.toString();

        }

        return "Order{" +
                ", pickupTime=" + Input.getMinutesToTimeFormat(pickupTime) +
                ", orderTime=" + orderTime +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' + "\n" +
                ", orderliner='" + allPizzas +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
