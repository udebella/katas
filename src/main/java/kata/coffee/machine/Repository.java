package kata.coffee.machine;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<Drinks, Integer> soldDrinks = new HashMap<>();

    public void track(Order order) {
        order.register(this);
    }

    public void track(Drinks drink) {
        soldDrinks.put(drink, soldDrinks.getOrDefault(drink, 0) + 1);
    }

    public void printReporting(Console console) {
        for (Map.Entry<Drinks, Integer> entry : soldDrinks.entrySet()) {
            console.print(entry.getKey() + " " + entry.getValue());
        }
    }
}
