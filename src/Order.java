import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order> {

    private int pizzaNr;
    private int amount;
    private int pickupTime;
    private Date orderTime;
    private String customerName;
    private String phone;
    private boolean removed;

    public Order(int pizzaNr, int amount, int pickupTime, String customerName, String phone) {
        this.pizzaNr = pizzaNr;
        this.amount = amount;
        this.pickupTime = pickupTime;
        this.customerName = customerName;
        this.phone = phone;
        this.orderTime = new Date();
        this.removed = false;
    }

    public int getPizzaNr() {
        return pizzaNr;
    }

    public void setPizzaNr(int pizzaNr) {
        this.pizzaNr = pizzaNr;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" +
                "pizzaNr = " + pizzaNr +
                ", amount = " + amount +
                ", pickupTime as int = " + pickupTime +
                ", pickupTime as text = kl. " + Input.getMinutesToTimeFormat(pickupTime) +
                ", orderTime = " + orderTime +
                ", customerName = '" + customerName + '\'' +
                ", phone = '" + phone + '\'' +
                ", removed = " + removed +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        return this.pickupTime - o.getPickupTime();
    }
}
