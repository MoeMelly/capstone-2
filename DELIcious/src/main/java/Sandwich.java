import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import static java.io.File.separator;

public class Sandwich implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    private final BreadSize size;
    private final BreadType type;
    private final boolean wantToast;
    private final Drinks drinks;
    private final Chips chips;
    List<Toppings> toppings;

    public Sandwich(BreadType type, BreadSize size, boolean wantToast, Drinks drink, Chips chips, List<Toppings> toppings) {
        this.size = size;
        this.type = type;

        this.wantToast = wantToast;
        this.drinks = drink;
        this.chips = chips;
        this.toppings = toppings;

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
    @Override
    public String toString() {
        return separator + System.lineSeparator()
                + "Bread Type: " + type + System.lineSeparator()
                + "Bread Size: " + size + System.lineSeparator()
                + "Toasted: " + wantToast + System.lineSeparator()
                + separator;
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


    }





