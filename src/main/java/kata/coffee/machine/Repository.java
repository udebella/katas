package kata.coffee.machine;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<Drink, Integer> soldDrinks = new HashMap<>();

    public void track(Order order) {
        order.register(this);
    }

    public void track(Drink drink) {
        soldDrinks.put(drink, soldDrinks.getOrDefault(drink, 0) + 1);
    }

    public void printReporting(Console console) {
        for (Map.Entry<Drink, Integer> entry : soldDrinks.entrySet()) {
            console.print(entry.getKey() + " " + entry.getValue());
        }
    }
}
