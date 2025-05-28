import java.io.Serializable;

public class Drinks  {
    DrinksSize size;


    public Drinks(DrinksSize size) {
        this.size = size;
    }

    public double getPrices() {

        return switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;

            default -> throw new IllegalArgumentException("Invalid input. Please try again.");
        };
    }

    @Override
    public String toString() {
        return String.format("Drink Size: %s | Price: $%.2f", size , getPrices());
    }


}


