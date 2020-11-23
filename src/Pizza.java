public class Pizza {
    int pizzaNo;
    String name;
    String ingredients;
    int price;

    public Pizza() {
    }

    public Pizza(int pizzaNo, String name, String ingredients, int price) {
        this.pizzaNo = pizzaNo;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getPizzaNo() {
        return pizzaNo;
    }

    public void setPizzaNo(int pizzaNo) {
        this.pizzaNo = pizzaNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "nr=" + pizzaNo +
                ", navn='" + name + '\'' +
                ", ingredienser='" + ingredients + '\'' +
                ", pris=" + price +
                '}';
    }
}
