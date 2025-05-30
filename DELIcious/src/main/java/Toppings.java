import java.util.ArrayList;
import java.util.List;

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


        List<Toppings> toppings = new ArrayList<>();
        String[] meats = {"STEAK", "HAM", "SALAMI", "ROAST BEEF", "CHICKEN", "BACON"};
        String[] cheeses = {"AMERICAN", "PROVOLONE", "CHEDDAR", "SWISS"};
        String[] regulars = {"LETTUCE", "PEPPERS", "ONIONS", "TOMATOES", "JALAPENOS", "CUCUMBERS", "PICKLES", "GUACAMOLE", "MUSHROOMS"};
        String[] sauces = {"BBQ","RANCH","KETCHUP","THOUSAND_ISLANDS","MAYO","MUSTARD"};

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
            for (String sauces1 : sauces) {
                toppings.add(new Toppings("SAUCES",sauces1,size,0.0));
            }
        }


        return toppings;


    }

    public static Toppings filterToppings(String toppingName, BreadSize size) {
        if (toppingName == null || toppingName.trim().isEmpty())
            return null;
        return getToppings().stream()
                .filter(t -> t.getName().equalsIgnoreCase(toppingName.trim()) && t.getSize() == size)
                .findFirst()
                .orElse(null);
    }


    public BreadSize getSize() {
        return size;
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













