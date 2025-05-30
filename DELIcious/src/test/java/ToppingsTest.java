import java.util.List;

class ToppingsTest {

    @org.junit.jupiter.api.Test
    void getToppings() {
        List<Toppings> toppings = Toppings.getToppings();
          List<Toppings> meats = toppings.stream()
                          .filter(m -> m.getName().equalsIgnoreCase("steak") && m.getSize() == BreadSize.MEDIUM)
                                  .toList();


        System.out.println();



    }

}




