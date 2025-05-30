public class Chips {
    private final double price;
    private final ChipsSize size;

    public Chips(ChipsSize size) {
        this.size = size;
        this.price = calculatePrice(size);
    }

    private double calculatePrice(ChipsSize size) {

        return switch (size) {
            case SMALL -> 1.50;
            case MEDIUM -> 2.0;
            case LARGE -> 2.50;
        };
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Chips Size: %s | Price: $%.2f", size , price);
    }
}
