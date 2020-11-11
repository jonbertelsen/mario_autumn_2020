public class OrderLine {
    Pizza pizza;
    int amount;

    public OrderLine(Pizza pizza, int amount) {
        this.pizza = pizza;
        this.amount = amount;
    }

    @Override
    public String toString() {
        String pizzaText = "";

        return "OrderLine{" +
                "pizza=" + pizza.toString() +
                ", amount=" + amount +
                "}\n";
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
