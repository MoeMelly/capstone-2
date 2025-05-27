import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements PriceCalc, Serializable {
    private String customerName;
    private String orderId;
    private List<Sandwiches> sandwiches;
    private LocalDateTime orderTime;
    private double totalPrice;

    public Order(String customerName, String orderId, List<Sandwiches> sandwiches, LocalDateTime orderTime, double totalPrice) {
        this.customerName = customerName;
        this.orderId = orderId;
        this.sandwiches = sandwiches;
        this.orderTime = orderTime;
        this.totalPrice = totalPrice;
    }



    public String getCustomerName() {
        return customerName;
    }

    public List<Sandwiches> getSandwiches() {
        return sandwiches;
    }

    public void addSandwich(Sandwiches s) {
        sandwiches.add(s);
        calculateTotalPrice();
    }

    public void removeSandwich(Sandwiches r) {
        sandwiches.remove(r);
        calculateTotalPrice();
    }

    @Override
    public void calculateTotalPrice() {
        totalPrice = 0.0;
        for (Sandwiches s : sandwiches) {
            double sandwichPrice = 0.0;
            switch (s.getBreadSize()) {
                case SMALL  -> sandwichPrice = 5.50;
                case MEDIUM -> sandwichPrice = 7.00;
                case LARGE -> sandwichPrice = 8.50;
            }


            if (s.getDrinks() != null) {
                sandwichPrice += s.getDrinks().getPrices(s.getDrinks().size);
            }

            if (s.getChips() != null) {
                sandwichPrice += 1.50;

                if (s.getToppings() != null) {
                    for (Toppings toppings : s.getToppings()) {
                        sandwichPrice += toppings.sizePrice(toppings.getSize());
                    }



                }
                totalPrice += sandwichPrice;
            }
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private OrderStatus status;

    public void updateStatus(OrderStatus status) {
        this.updateStatus(status);

    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }
    public static Order loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Order) ois.readObject();

        }
    }


    }









