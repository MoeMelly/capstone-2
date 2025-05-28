import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order("Lil Melly", "PO12O", new ArrayList<>(), LocalDateTime.now(), null, null, 0.0);
        boolean keepGoing = true;

        while (keepGoing) {
            System.out.println("1.Build Sandwich");
            System.out.println("2.Add Chips");
            System.out.println("3.Add Drink");
            System.out.println("4.View Order");
            System.out.println("5.Checkout Order");
            System.out.println("0.Exit");
            String input = scanner.nextLine();
            switch (input)
        }
    }

        public static Sandwich buildSandwich(Scanner scanner) {

        }
        public static Chips addChips(Scanner scanner) {

        }
        public static Drinks addDrink(Scanner scanner) {

        }
        public void viewOrder(Order order) {

        }
        public void checkOut(Order order) {

        }



    }
}




















