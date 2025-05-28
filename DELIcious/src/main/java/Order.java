import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order implements PriceCalc {
    private final String customerName;
    private final String orderId;
    private final List<Sandwich> sandwiches;
    private final LocalDateTime orderTime;
    private Chips chips;
    private Drinks drink;
    private double totalPrice;

    public Order(String customerName, String orderId, List<Sandwich> sandwiches, LocalDateTime orderTime,Chips chips, Drinks drink, double totalPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.sandwiches = new ArrayList<>(sandwiches != null ? sandwiches : List.of());
        this.orderTime = orderTime;
        this.chips = null;
        this.drink = null;
        this.totalPrice = totalPrice;
    }


    public String getCustomerName() {
        return customerName;
    }

    public String getOrderId() {
        return orderId;
    }
    public Chips getChips() {
        return chips;
    }

    public Drinks getDrink() {
        return drink;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void addSandwich() {
        if (sandwiches != null) {
            sandwiches.add((Sandwich) sandwiches);
            calculateTotalPrice();
        }
    }

    public void removeSandwich(Sandwich r) {
        if (r != null) {
            sandwiches.remove(r);
            calculateTotalPrice();
        }
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = 0.0;
        for (Sandwich s : sandwiches) {
            double sandwichPrice = 0.0;
            switch (s.getSize()) {
                case SMALL -> sandwichPrice = 5.50;
                case MEDIUM -> sandwichPrice = 7.00;
                case LARGE -> sandwichPrice = 8.50;
            }


            if (s.getDrinks() != null) {
                sandwichPrice += s.getDrinks().getPrices();
            }

            if (s.getChips() != null) {
                sandwichPrice += 1.50;
            }

            if (s.getToppings() != null) {
                for (Toppings toppings : s.getToppings()) {
                    sandwichPrice += toppings.sizePrice(toppings.getSize());
                }


            }
            totalPrice += sandwichPrice;
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void writeToFile(Sandwich sandwich, String filename) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fileName = "src/main/resources/receipt.txt";
        LocalDateTime timestamp = LocalDateTime.now();
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(fileName, true)) {
            };
            wr.write("-------RECEIPT------");
            wr.write("TimeStamp: " + timestamp + "\n");
            wr.write("Bread type: " + sandwich.getType() + "\n");
            wr.write("Bread size: " + sandwich.getSize() + "\n");
            wr.write("Toasted: " + (sandwich.isWantToast() ? "Yes" : "No") + "\n");

            wr.write("\nToppings:\n");
            for (Toppings toppings : sandwich.getToppings()) {
                wr.write("-" + toppings.toString() + "\n");
            }
            if (sandwich.getDrinks() != null) {
                wr.write("\nDrink:\n" + sandwich.getDrinks().toString() + "\n");
            }
            if (sandwich.getChips() != null) {
                wr.write("\nChips:\n" + sandwich.getChips().toString() + "\n");
            }

            wr.write("\n-----------------------------\n");


        } catch (IOException ex) {
            System.err.println("Error Writing to file.");
            throw new RuntimeException(ex);
        }
    }

        public void viewOrder(Sandwich sandwich) {
            System.out.println("-----Order Summary-----");
            System.out.println("Sandwich: " + sandwich.getType());

            System.out.println("Toppings:");
            for (Toppings topping : sandwich.getToppings()) {
                System.out.println("--" + topping);
        }
            if(chips != null) {
                System.out.println("Chips: " + chips.getPrice());
            }
            if (drink !=null) {
                System.out.println("Drink: " + drink.getPrices());
            }
            System.out.println("Total Price: $" + totalPrice);

    }



    }


















