import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sandwich {
    private final BreadSize size;
    private final BreadType type;
    private final boolean wantToast;
    private final Drinks drinks;
    private final Chips chips;
    private final List<Toppings> toppings;
    private final List<Sauces> sauces;

    public Sandwich(BreadType type, BreadSize size, boolean wantToast, Drinks drink, Chips chips, List<Toppings> toppings, List<Sauces> sauces) {
        this.size = size;
        this.type = type;
        this.wantToast = wantToast;
        this.drinks = drink;
        this.chips = chips;
        this.toppings = (toppings == null) ? Collections.emptyList() : new ArrayList<>(toppings);
        this.sauces = (sauces == null) ? Collections.emptyList() : new ArrayList<>(sauces);
    }

    public boolean isWantToast() {
        return wantToast;
    }

    public BreadSize getSize() {
        return size;
    }

    public BreadType getType() {
        return type;
    }

    public Drinks getDrinks() {
        return drinks;
    }

    public Chips getChips() {
        return chips;
    }

    public List<Sauces> getSauces() {
        return sauces;
    }

    public List<Toppings> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return type + "(" + size + "," + (wantToast ? "Toasted" : "Not Toasted") + ") | Toppings: " + (toppings.isEmpty() ? "None" : toppings.toString().replaceAll("[\\[\\]]", "")) + "| Chips: " + (chips == null ? "None" : "$" + String.format("%.2f", chips.getPrice()) + " | Drinks: " + (drinks == null ? "None" : "$" + String.format("%.2f",drinks.getPrice()))

        );
    }
}


