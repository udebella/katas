package kata.coffee.machine.reporting;

import kata.coffee.machine.Amount;
import kata.coffee.machine.Order;
import kata.coffee.machine.drinks.Drinks;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private final Map<Drinks, Amount> soldDrinks = new HashMap<>();

    public void track(Order order) {
        order.register(this);
    }

    public void track(Drinks drink, Amount amount) {
        soldDrinks.put(drink, soldDrinks.getOrDefault(drink, Amount.of(0)).add(amount));
    }

    public void printReporting(Console console) {
        for (Map.Entry<Drinks, Amount> entry : soldDrinks.entrySet()) {
            console.print(entry.getKey() + ": " + entry.getValue().format());
        }
    }
}
