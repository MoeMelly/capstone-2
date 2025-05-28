import java.io.Serializable;
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



    public BreadSize getSize() {
        return size;
    }

    public String getType() {
        return toppingType;
    }

    public String getName() {
        return name;
    }


    public static List<Toppings> getToppings() {
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Toppings("MEAT", "STEAK", BreadSize.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "HAM", BreadSize.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "SALAMI", BreadSize.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "ROAST BEEF", BreadSize.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "CHICKEN", BreadSize.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "BACON", BreadSize.SMALL, 1.00));


        toppings.add(new Toppings("CHEESE", "AMERICAN", BreadSize.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "PROVOLONE", BreadSize.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "CHEDDAR", BreadSize.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "SWISS", BreadSize.SMALL, .75));


        toppings.add(new Toppings("REGULAR TOPPINGS", "LETTUCE", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "PEPPERS", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "ONIONS", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "TOMATOES", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "JALAPENOS", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "CUCUMBERS", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "PICKLES", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "GUACAMOLE", BreadSize.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "MUSHROOMS", BreadSize.SMALL, .20));


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

    public double sizePrice(BreadSize size) {

        return switch (size) {
            case SMALL -> this.price;
            case MEDIUM -> this.price * 2;
            case LARGE -> this.price * 3;

        };

    }


    public static List<Toppings> filterToppings(List<Toppings> toppings, String type, String name, BreadSize size) {

        if (toppings == null || toppings.isEmpty()) return Collections.emptyList();


        return toppings.stream()
                .filter(toppings1 -> toppings1.getName().equalsIgnoreCase(name))
                .filter(toppings1 -> toppings1.getType().equalsIgnoreCase(type))
                .filter(toppings1 -> toppings1.getSize() == size)
                .toList();
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


    @Override
    public String toString() {
        return String.format("%s (%s) - $%.2f", name, size, price);


    }
}







