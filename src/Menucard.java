import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menucard {

    private final String BEGIN = "BEGIN";
    private final String END = "END";
    private final String NO = "NO";
    private final String NAME = "NAME";
    private final String INGREDIENTS = "INGREDIENTS";
    private final String PRICE = "PRICE";

    List<Pizza> menuCard;

    public Menucard() {
        this.menuCard = new ArrayList<Pizza>();
    }

    public void addPizza(Pizza pizza){
        menuCard.add(pizza);
    }

    public void readPizzasFromFile(String fileName){
        String line = "";
        String token = "";
        Pizza pizza = null;

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
