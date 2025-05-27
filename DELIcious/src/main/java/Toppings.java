import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Toppings implements Serializable {
    String type;
    String name;
    Size size;
    double price;

    public Toppings(String type, String name, Size size, double price) {
        this.type = type;
        this.name = name;
        this.size = size;
        this.price = price;

    }


    public Size getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public static List<Toppings> getToppings() {
        List<Toppings> toppings = new ArrayList<>();
        toppings.add(new Toppings("MEAT", "STEAK", Size.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "HAM", Size.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "SALAMI", Size.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "ROAST BEEF", Size.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "CHICKEN", Size.SMALL, 1.00));
        toppings.add(new Toppings("MEAT", "BACON", Size.SMALL, 1.00));


        toppings.add(new Toppings("CHEESE", "AMERICAN", Size.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "PROVOLONE", Size.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "CHEDDAR", Size.SMALL, .75));
        toppings.add(new Toppings("CHEESE", "SWISS", Size.SMALL, .75));


        toppings.add(new Toppings("REGULAR TOPPINGS", "LETTUCE", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "PEPPERS", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "ONIONS", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "TOMATOES", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "JALAPENOS", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "CUCUMBERS", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "PICKLES", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "GUACAMOLE", Size.SMALL, .20));
        toppings.add(new Toppings("REGULAR TOPPINGS", "MUSHROOMS", Size.SMALL, .20));


        return toppings;


    }


    public static double extraCharge(List<String> extras, Size size) {
        double surCharge = 0.0;

        for (String extra : extras) {
            switch (extra.toLowerCase()) {
                case "extra meat":
                    switch (size) {
                        case SMALL:
                            surCharge += 0.75;
                            break;
                        case MEDIUM:
                            surCharge += 1.00;
                            break;
                        case LARGE:
                            surCharge += 1.50;
                            break;
                    }
                    break;
                case "extra cheese":
                    switch (size) {
                        case SMALL:
                            surCharge += 0.30;
                            break;
                        case MEDIUM:
                            surCharge += 0.60;
                            break;
                        case LARGE:
                            surCharge += 0.90;
                            break;
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid extra: " + extra);
            }
        }

        return surCharge;
    }

    public double sizePrice(Size size) {

        return switch (size) {
            case SMALL -> this.price;
            case MEDIUM -> this.price * 2;
            case LARGE -> this.price * 3;

        };

    }

    public List<Toppings> filterToppings(List<Toppings> toppings, String type, String name, Size size) {

        if (toppings.isEmpty()) {
            return Collections.emptyList();
        }

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
        return name;


    }
}




