package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CoffeeMachine {
    private Map<DrinkType,Integer> soldDrink = new HashMap<>();

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .map(drinkType -> {
                    soldDrink.put(drinkType,soldDrink.getOrDefault(drinkType,0)+1);
                    return drinkType;
                })
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElseThrow(NoSuchElementException::new);
    }

    public void report(Printer printer) {
        printer.print("Drink type   | Number sold | Money earned");
        for (DrinkType drinkType : DrinkType.values()) {
            if (soldDrink.containsKey(drinkType)) {
                printer.print(drinkType.printReport(soldDrink.get(drinkType)));
            } else {
                printer.print(drinkType.printReport(0));
            }
        }
    }
}
