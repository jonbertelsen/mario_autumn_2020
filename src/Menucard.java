import java.util.ArrayList;
import java.util.List;

public class Menucard {

    List<Pizza> menuCard;

    public Menucard() {
        this.menuCard = new ArrayList<Pizza>();
    }

    public void addPizza(Pizza pizza){
        menuCard.add(pizza);
    }

    public void readPizzasFromFile(String fileName){

    }

    public void showMenuCard(){
        System.out.println("******* Menukort hos Mario *******");
        for (Pizza pizza : menuCard) {
            System.out.print(pizza.nr + ". ");
            System.out.print(pizza.navn + ": ");
            System.out.print(pizza.ingredienser + " ...... ");
            System.out.println(pizza.pris + " kr.");
        }
    }
}
