import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements PriceCalc {
    private final String customerName;
    private final String orderId;
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<Toppings> toppings = new ArrayList<>();
    private final List<Drinks> drinks = new ArrayList<>();
    private final List<Chips> chips = new ArrayList<>();
    private final LocalDateTime orderTime;
    private double totalPrice;

    public Order(String customerName, String orderId, List<Sandwich> sandwiches, List<Toppings> toppings,
                 List<Drinks> drinks, List<Chips> chips, LocalDateTime orderTime, double totalPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        if (sandwiches != null) this.sandwiches.addAll(sandwiches);
        if (toppings != null) this.toppings.addAll(toppings);
        if (drinks != null) this.drinks.addAll(drinks);
        if (chips != null) this.chips.addAll(chips);
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
    }

    public String getCustomerName() { return customerName; }
    public String getOrderId() { return orderId; }
    public List<Sandwich> getSandwiches() { return sandwiches; }
    public List<Toppings> getToppings() { return toppings; }
    public List<Drinks> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips; }
    public LocalDateTime getOrderTime() { return orderTime; }
    public double getTotalPrice() { return totalPrice; }

    public void addSandwich(Sandwich sandwich) {
        if (sandwich != null) {
            sandwiches.add(sandwich);
            calculateTotalPrice();
        }
    }

    public void addDrink(Drinks drink) {
        if (drink != null) {
            drinks.add(drink);
            calculateTotalPrice();
        }
    }

    public void addChips(Chips chip) {
        if (chip != null) {
            chips.add(chip);
            calculateTotalPrice();
        }
    }

    public void removeSandwich(Sandwich sandwich) {
        if (sandwich != null) {
            sandwiches.remove(sandwich);
            calculateTotalPrice();
        }
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = 0.0;

        for (Sandwich s : sandwiches) {
            double sandwichPrice = switch (s.getSize()) {
                case SMALL -> 5.50;
                case MEDIUM -> 7.00;
                case LARGE -> 8.50;
            };

            if (s.getDrinks() != null) {
                sandwichPrice += s.getDrinks().getPrice();
            }

            if (s.getChips() != null) {
                sandwichPrice += s.getChips().getPrice();
            }

            if (s.getToppings() != null) {
                for (Toppings topping : s.getToppings()) {
                    sandwichPrice += topping.sizePrice(topping.getSize());
                }
            }

            totalPrice += sandwichPrice;
        }

        for (Drinks drink : drinks) {
            totalPrice += drink.getPrice();
        }

        for (Chips chip : chips) {
            totalPrice += chip.getPrice();
        }
    }

    public void viewOrder() {
        System.out.println("----- Order Summary -----");
        System.out.println("Customer: " + customerName);
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Time: " + orderTime);

        System.out.println("\nSandwiches:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println("- " + sandwich.getType() + " (" + sandwich.getSize() + ")");
            System.out.println("  Toppings");
            for (Toppings topping : sandwich.getToppings()) {
                System.out.println("    * " + topping);
            }
        }

        System.out.println("\nDrinks:");
        for (Drinks drink : drinks) {
            System.out.println("- " + drink + " - $" + String.format("%.2f", drink.getPrice()));
        }

        System.out.println("\nChips:");
        for (Chips chip : chips) {
            System.out.println("- " + chip + " - $" + String.format("%.2f", chip.getPrice()));
        }

        System.out.printf("\nTotal Price: $%.2f%n", totalPrice);
    }
}
