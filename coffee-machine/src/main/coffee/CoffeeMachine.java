package coffee;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class CoffeeMachine {
    private Set<DrinkType> soldDrink = new HashSet<>();

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .map(drinkType -> {
                    soldDrink.add(drinkType);
                    return drinkType;
                })
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElseThrow(NoSuchElementException::new);
    }

    public void report(Printer printer) {
        printer.print("Drink type   | Number sold | Money earned");
        for (DrinkType drinkType : DrinkType.values()) {
            if (soldDrink.contains(drinkType)) {
                printer.print(drinkType.getName() + " | 1 | " + drinkType.getPrice());
            } else {
                printer.print(drinkType.getName() + " | 0 | 0");
            }
        }
    }
}
