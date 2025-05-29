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
            System.out.println("----MEllYs SANDWICH SHOP----");
            System.out.println("1.Begin Building Your Sandwich Now! ");
            System.out.println("0.Exit");
            String input = scanner.nextLine();
            switch (input) {
                case "1" -> {
                    Order currentOrder = new Order("LIL Melly", "PO90K", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), LocalDateTime.now(), 0.0);
                    orderScreen(currentOrder);
                }
                case "0" -> keepGoing = false;
                default -> System.out.println("Invalid option. Please try again.");
            }

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
                    if (drinks != null) currentOrder.addDrink(drinks);
                    break;
                case "3":
                    Chips chips = addChips();
                    if (chips != null) currentOrder.addChips(chips);
                    break;
                case "4":
                    sendToReceipt(currentOrder);
                    currentOrder.viewOrder();
                    keepGoing = false;
                    break;
                case "0":
                    keepGoing = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }


        }


        return "exit";
    }

    public static Sandwich addSandwich() {
        System.out.println("Choose Bread Size: (SMALL,MEDIUM,LARGE):");
        BreadSize size = BreadSize.valueOf(scanner.nextLine().trim().toUpperCase());
        System.out.println("Choose Bread Type (WHITE,WHEAT,RYE,WRAP): ");
        BreadType type = BreadType.valueOf(scanner.nextLine().trim().toUpperCase());
        System.out.println("Do you want it toasted? (yes/no): ");
        boolean toast = scanner.nextLine().trim().equalsIgnoreCase("yes");


        List<Toppings> toppings = new ArrayList<>();
        boolean addToppings = true;
        while (!addToppings) {
            System.out.println("Enter Topping name (Type 'done to finish): ");
            String toppingName = scanner.nextLine();
            if (toppingName.equalsIgnoreCase("done"))
                break;

            System.out.println("Enter topping size (SMALL, MEDIUM, LARGE):");
            String sizeInput = scanner.nextLine().trim().toUpperCase();

            try {
                BreadSize toppingSize = BreadSize.valueOf(sizeInput);
                Toppings select = Toppings.filterToppings(toppingName, toppingSize);
                if (select != null) {
                    toppings.add(select);
                    System.out.println("Added: " + select);
                } else {
                    System.out.println("Topping not found.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid size. try again please.");

            }

        }
        Drinks drinks = addDrinks();
        Chips chips = addChips();
        return new Sandwich(type, size, toast, drinks, chips, toppings);
    }


    public static Drinks addDrinks() {
        System.out.println("Our Flavor Machine is down. Only water.");
        System.out.println("Choose a Drink Size (SMALL, MEDIUM,LARGE):");
        String input = scanner.nextLine().trim().toUpperCase();
        try {
            DrinksSize size = DrinksSize.valueOf(input);
            double price = switch (size) {
                case SMALL -> 1.00;
                case MEDIUM -> 1.50;
                case LARGE -> 2.00;
            };
            return new Drinks("Water",size,price) ;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. no drink added");
            return null;
        }


    }

    public static Chips addChips() {
        System.out.println("Choose chip size (SMALL,MEDIUM,LARGE):");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            ChipsSize size = ChipsSize.valueOf(input);
            return new Chips(size);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. No chips added.");
        }
        return null;
    }

    public static Order sendToReceipt(Order currentOrder) {
        currentOrder.calculateTotalPrice();
        FileIo.saveToReceipt(currentOrder);


        return currentOrder;
    }

}


































