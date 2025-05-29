import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Toppings {
    private final String toppingType;
    private final String name;
    private final BreadSize size;
    private final double price;

    public Toppings(String toppingType, String name, BreadSize size, double price) {
        this.toppingType = toppingType;
        this.name = name;
        this.size = size;
        this.price = price;

    }

    public static List<Toppings> getToppings() {
        double smallMeatPrice = 1.00;
        double smallCheese = 0.75;
        double regular = 0.20;


        List<Toppings> toppings = new ArrayList<>();
        String[] meats = {"STEAK", "HAM", "SALAMI", "ROAST BEEF", "CHICKEN", "BACON"};
        String[] cheeses = {"AMERICAN", "PROVOLONE", "CHEDDAR", "SWISS"};
        String[] regulars = {"LETTUCE", "PEPPERS", "ONIONS", "TOMATOES", "JALAPENOS", "CUCUMBERS", "PICKLES", "GUACAMOLE", "MUSHROOMS"};

        for (BreadSize size : BreadSize.values()) {
            double multiplier = switch (size) {
                case SMALL -> 1;
                case MEDIUM -> 2;
                case LARGE -> 3;
            };
        }




        for (BreadSize size : BreadSize.values()) {
            for (String meat : meats) {
                toppings.add(new Toppings("MEAT", meat, size, 1.00));

            }
            for (String cheese : cheeses) {
                toppings.add(new Toppings("CHEESE",cheese,size,0.75));
            }
            for (String regularTop : regulars) {
                toppings.add(new Toppings("REGULAR TOPPINGS",regularTop,size,0.20));
            }
        }


        return toppings;


    }

    public static double extraCharge(List<String> extras, BreadSize size) {
        double surCharge = 0.0;

        for (String extra : extras) {
            switch (extra.toLowerCase()) {
                case "extra meat" -> surCharge += switch (size) {
                    case SMALL -> 0.75;
                    case MEDIUM -> 1.00;
                    case LARGE -> 1.50;

                };

                case "extra cheese" -> {
                    surCharge += switch (size) {
                        case SMALL -> 0.30;
                        case MEDIUM -> 0.60;
                        case LARGE -> 0.90;
                    };
                }
                default -> throw new IllegalArgumentException("Invalid extra: " + extra);
            }
        }
        return surCharge;
    }

    public static Toppings filterToppings(String name, BreadSize size) {
        if (name == null || name.trim().isEmpty())
            return null;
        return getToppings().stream()
                .filter(t -> t.getName().equalsIgnoreCase(name.trim()) && t.getSize() == size)
                .findFirst()
                .orElse(null);
    }

    public static void printToppingsByCategory(List<Toppings> toppings) {
        String meat = toppings.stream()
                .filter(toppings1 -> "MEAT".equalsIgnoreCase(toppings1.getType()))
                .map(Toppings::toString)
                .collect(Collectors.joining());


        String cheese = toppings.stream()
                .filter(toppings1 -> "CHEESE".equalsIgnoreCase(toppings1.getType()))
                .map(Toppings::toString)
                .collect(Collectors.joining());


        String regularToppings = toppings.stream()
                .filter(toppings1 -> "REGULAR TOPPINGS".equalsIgnoreCase(toppings1.getType()))
                .map(Toppings::toString).collect(Collectors.joining());


        System.out.println("MEAT TOPPINGS:\n" + meat);
        System.out.println("CHEESE:\n" + cheese);
        System.out.println("REGULAR TOPPINGS:\n" + regularToppings);


    }


    public BreadSize getSize() {
        return size;
    }

    public String getType() {
        return toppingType;
    }

    public String getName() {
        return name;
    }

    public double sizePrice(BreadSize size) {

        return switch (size) {
            case SMALL -> this.price;
            case MEDIUM -> this.price * 2;
            case LARGE -> this.price * 3;

        };

    }

    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", name, size, sizePrice(size));



    }
}













