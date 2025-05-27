import java.io.Serializable;

public class Chips implements Serializable {
    private double price;
    private String size;

    public Chips(String size) {
        this.size = size;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(String size) {
        switch (size.toUpperCase()) {
            case "S":
                return 1.50;
            case "M":
                return 2.00;
            case "L":
                return 2.50;
            default:
                throw new IllegalArgumentException("Unexpected chip size: " + size);
        }
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Chips Size: %s | Price: $%.2f", size.toUpperCase(), price);
    }
}
