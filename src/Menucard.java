import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menucard {

    IDataMapper dataMapper = new FileDataMapper();
    List<Pizza> menuCard;

    public Menucard(IDataMapper dataMapper) {
        this.menuCard = dataMapper.readPizzas();
    }

    public void addPizza(Pizza pizza){
        menuCard.add(pizza);
    }

    public void showMenuCard(){
        System.out.println("******* Menukort hos Mario *******");
        for (Pizza pizza : menuCard) {
            System.out.print(pizza.pizzaNo + ". ");
            System.out.print(pizza.name + ": ");
            System.out.print(pizza.ingredients + " ...... ");
            System.out.println(pizza.price + " kr.");
        }
        System.out.println();
    }

    public int getPriceByPizzaNo(int pizzaNo){
        for (Pizza pizza : menuCard) {
            if (pizza.pizzaNo == pizzaNo){
                return pizza.getPrice();
            }
        }
        return 0;
    }
}
