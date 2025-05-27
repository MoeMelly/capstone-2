import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements PriceCalc, Serializable {
    private static final long serialVersionUTD1L = 1L;
    private String customerName;
    private String orderId;
    private List<Sandwich> sandwiches;
    private LocalDateTime orderTime;
    private double totalPrice;
    private OrderStatus status;

    public Order(String customerName, String orderId, List<Sandwich> sandwiches, LocalDateTime orderTime, double totalPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.sandwiches = new ArrayList<>();
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
    }

    public static Order loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Order) ois.readObject();

        }
    }


    public String getCustomerName() {
        return customerName;
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwich s) {
        sandwiches.add(s);
        calculateTotalPrice();
    }

    public void removeSandwich(Sandwich r) {
        sandwiches.remove(r);
        calculateTotalPrice();
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = 0.0;
        for (Sandwich s : sandwiches) {
            double sandwichPrice = 0.0;
            switch (s.getSize()) {
                case SMALL  -> sandwichPrice = 5.50;
                case MEDIUM -> sandwichPrice = 7.00;
                case LARGE -> sandwichPrice = 8.50;
            }


            if (s.getDrinks() != null) {
                sandwichPrice += s.getDrinks().getPrices(s.getDrinks().size);
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

    public void updateStatus(OrderStatus status) {
        this.status =status;

    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }
}












