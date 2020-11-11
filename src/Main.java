public class Main {

    public static void main(String[] args) {

        Menucard menuCard = new Menucard();
        menuCard.readPizzasFromFile("menucard.txt");


        Pizza vesuvio = new Pizza(1, "Calzone", "Ost og Tomat", 57);
        Pizza calzone = new Pizza(1, "Vesuvio", "Ost og Tomat", 75);
        menuCard.addPizza(calzone);
        menuCard.addPizza(vesuvio);

        menuCard.showMenuCard();

        OrderList ordrer = new OrderList();

        ordrer.addOrder(new Order(1, 1, Input.convertTimeFromTextToInt("19.30"), "Jønke", "2323232"));
        ordrer.addOrder(new Order(13, 2, Input.convertTimeFromTextToInt("19.15"), "Blondie", "23453232"));
        ordrer.addOrder(new Order(8, 4, Input.convertTimeFromTextToInt("19.45"), "Makrellen", "234532"));
        ordrer.addOrder(new Order(3, 1, Input.convertTimeFromTextToInt("18.30"), "Fehår", "234353232"));

        System.out.println("Ordreliste før sortering:");
        System.out.println(ordrer.toString());
        System.out.println("Ordreliste efter sortering:");
        ordrer.sortOrders();
        System.out.println(ordrer.toString());

    }
}
