import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showHomeScreen();
    }

        public static String showHomeScreen() {
            boolean keepGoing = true;
            while (keepGoing) {
                System.out.println("\n-------Melly and Mo's Sandwiches-------");
                System.out.println("1.Start A New Order.");
                System.out.println("0.Exit");
                String input = scanner.nextLine();
                switch (input) {
                    case "1" -> {
                    Order  currentOrder = new Order("LIL Melly","PO90K",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),LocalDateTime.now(),0.0);
                    orderScreen(currentOrder);
                    }
                    case "0" -> {
                        keepGoing = false;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                };
            }
            return "exit";
        }
        public static String orderScreen(Order currentOrder) {
         boolean keepGoing = true;
         while (keepGoing) {
             System.out.println("--------Order Menu--------");
             System.out.println("1.Add Sandwich");
             System.out.println("2.Add Drink");
             System.out.println("3.Add Chips");
             System.out.println("4.Checkout");
             System.out.println("0.Cancel Order");
             String input = scanner.nextLine();

             switch (input) {
                 case "1":
                 Sandwich sandwich = addSandwich();
                 currentOrder.addSandwich(sandwich);
                 break;
                 case "2":
                     Drinks drinks = addDrinks();
                     currentOrder.addDrink(drinks);
                     break;
                 case "3":
                     Chips chips = addChips();
                     currentOrder.addChips(chips);
                 case "4":
                    finalizeOrder(currentOrder);
                    currentOrder.viewOrder();
                    break;

             }

         }



            return "exit";
        }
        public static Sandwich addSandwich() {
            System.out.println("Choose Bread Type (SMALL,MEDIUM,LARGE)");
            String sizes = scanner.nextLine().toUpperCase();
            BreadSize size = BreadSize.valueOf(sizes);

          List<Toppings> toppings = new ArrayList<>();
            boolean keepGoing = true;
            while (keepGoing) {
                System.out.println("Choose a Topping Category: ");
                System.out.println("1.Meat.");
                System.out.println("2.Cheese.");
                System.out.println("3.Regular Toppings.");
                System.out.println("4.Done.");
                String input = scanner.nextLine();

                switch (input) {
                    case "1" -> {


                    }
                    default -> throw new IllegalStateException("Unexpected value: " + input);
                }


            }

            return null;
        }

    public static Drinks addDrinks() {

        return null;
    }

    public static Chips addChips() {

        return null;
    }

    public static Order finalizeOrder(Order currentOrder) {

        return null;
    }

    public static void saveReceipt() {

    }


        }





























