import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.io.File.separator;

public class Sandwich implements PriceCalc {
    private static final String SEPARATOR = "------------------------------------------";
    private final BreadSize size;
    private final BreadType type;
    private final boolean wantToast;
    private final Drinks drinks;
    private final Chips chips;
    private List<Toppings> toppings;

    public Sandwich(BreadType type, BreadSize size, boolean wantToast, Drinks drink, Chips chips, List<Toppings> toppings) {
        this.size = size;
        this.type = type;
        this.wantToast = wantToast;
        this.drinks = drink;
        this.chips = chips;
        this.toppings = toppings == null ? Collections.emptyList() : new ArrayList<>(toppings);

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

    public List<Toppings> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return String.format(
                "Sandwich: %s (%s, %s) | Toppings: %s | Chips: %s | Drinks: %s | Total: $%.2f",
                type,
                size,
                wantToa
        );
    }




    @Override
    public void calculateTotalPrice() {
        System.out.println(this.toString());

    }
}





