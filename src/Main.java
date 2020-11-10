public class Main {

    public static void main(String[] args) {

        Menucard menuCard = new Menucard();


        menuCard.readPizzasFromFile("menucard.txt");

        // Vis: Program menu

        menuCard.showMenuCard();

        Pizza calzone = new Pizza(1, "Vesuvio", "Ost og Tomat", 57);
        menuCard.addPizza(calzone);

        int tid = Input.getTimeInMinutes("Afhentingstid: ");

        Order o1 = new Order(1, 2, tid, "Jon", "22755844");

        System.out.println(o1.toString());




    }
}
