import UI.Input;

public class Main {

    public static void main(String[] args) {

        Menucard menuCard = new Menucard();


        menuCard.readPizzasFromFile("menucard.txt");

        // Vis: Program menu

        menuCard.showMenuCard();

        Pizza vesuvio = new Pizza(1, "Calzone", "Ost og Tomat", 57);
        Pizza calzone = new Pizza(1, "Vesuvio", "Ost og Tomat", 75);
        menuCard.addPizza(calzone);

        int tid = Input.getTimeInMinutes("Afhentingstid: ");

        Order o1 = new Order(tid, "Jon", "22755844");
        o1.addPizza(vesuvio,2);
        o1.addPizza(calzone,4);

        System.out.println(o1.toString());





    }
}
