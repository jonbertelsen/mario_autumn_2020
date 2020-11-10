import java.util.Date;

public class Order {

    private int pizzaNo;
    private int amount;
    private int pickupTime;
    private Date orderTime;
    private String customerName;
    private String phone;
    private boolean removed;

    public Order(int pizzaNo, int amount, int pickupTime, String customerName, String phone) {
        this.pizzaNo = pizzaNo;
        this.amount = amount;
        this.pickupTime = pickupTime;
        this.customerName = customerName;
        this.phone = phone;
        this.orderTime = new Date();
        this.removed = false;
    }

    public int getPizzaNo() {
        return pizzaNo;
    }

    public void setPizzaNo(int pizzaNo) {
        this.pizzaNo = pizzaNo;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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
        return "Order{" +
                "pizzaNo=" + pizzaNo +
                ", amount=" + amount +
                ", pickupTime=" + Input.getMinutesToTimeFormat(pickupTime) +
                ", orderTime=" + orderTime +
                ", customerName='" + customerName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
