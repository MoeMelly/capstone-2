public class Drinks {
    String water;
    private final DrinksSize size;
    private final double price;

    public Drinks(String water, DrinksSize size, double price) {
        this.water = water;
        this.size = size;
        this.price = calculatePriceFromSize(size);
    }

    private double calculatePriceFromSize(DrinksSize size) {
        return switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Drink Size: %s | Price: $%.2f", size, price);
    }
}



