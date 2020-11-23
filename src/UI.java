public class UI {

    IDataMapper dataMapper = new FileDataMapper();
    Menucard menuCard = new Menucard(dataMapper);
    OrderList orderList = new OrderList(dataMapper);
    int choice = 0;

    public void mainMenu(){
        orderList.readOrders();
        boolean running = true;
        String input = "";

        while (running){
            showMenu();
            choice = Input.getInt("Hvad vil du? ");
            switch (choice){
                case 1: menuCard.showMenuCard(); break;
                case 2: createNewOrder(); break;
                case 3: orderList.showOrderList(menuCard); break;
                case 4:
                    int orderNo = Input.getInt("Indtast ordrenummer: ");
                    orderList.removeOrder(orderNo);
                    System.out.println(String.format("Ordre nummer %s er fjernet", orderNo)); break;
                case 9:
                    orderList.persistOrderList();
                    System.out.println("Så er data gemt. Tak for denne gang!");
                    running = false;
                break;
            }
        }
    }

    private void createNewOrder() {
        int orderNo = orderList.getTotalNumberOfOrders() + 1;
        int pizzaNo = Input.getInt("Indtast pizza nummer: ");
        int amount = Input.getInt("Hvor mange stk? ");
        int pickupTime = Input.getTimeInMinutes("Afhentningstidspunkt tt.mm");
        String name = Input.getString("Dit navn? ");
        String phone = Input.getString("Dit telefonnummmer: ");
        Order newOrder = new Order(orderNo, pizzaNo, amount, pickupTime, name, phone);
        orderList.addOrder(newOrder);
        orderList.sortOrders();
    }

    private void showMenu(){
        System.out.println("**** Marios Pizzabar ******");
        System.out.println("[1] Vis menu [2] Opret ordre [3] Vis ordrer [4] Fjern ordre [9] Afslut");
    }

}
