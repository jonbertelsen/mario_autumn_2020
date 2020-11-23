import java.util.Date;

public class Order implements Comparable<Order> {

    private int orderNo;
    private int pizzaNo;
    private int amount;
    private int pickupTime;
    private Date orderTime;
    private String customerName;
    private String phone;
    private boolean removed;

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public Order() {
    }

    public Order(int orderNo, int pizzaNo, int amount, int pickupTime, String customerName, String phone) {
        this.orderNo = orderNo;
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

    public String showOrderDetails(Menucard menuCard) {
        return  "orderNo: " + orderNo +
                ", pizzaNo: " + pizzaNo +
                ", amount: " + amount +
                ", totalprice: " + amount * menuCard.getPriceByPizzaNo(pizzaNo) + " kr. " +
                ", pickupTime: " + Input.getMinutesToTimeFormat(pickupTime) +
                ", customer = '" + customerName + '\'' +
                ", phone = '" + phone + '\'' +
                ", removed = " + removed +
                ", orderTime: " + orderTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo = " + orderNo +
                ", pizzaNo = " + pizzaNo +
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
