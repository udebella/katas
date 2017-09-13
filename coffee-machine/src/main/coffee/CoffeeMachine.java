package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CoffeeMachine {
    private Map<DrinkType,Integer> soldDrink = new HashMap<>();

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .map(drinkType -> {
                    final Integer numberSold = soldDrink.getOrDefault(drinkType, 0);
                    soldDrink.put(drinkType, numberSold + 1);
                    return drinkType;
                })
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElseThrow(NoSuchElementException::new);
    }

    public void report(Printer printer) {
        printer.print("Drink type   | Number sold | Money earned");
        Stream.of(DrinkType.values())
                .map(drinkType -> {
                    final Integer numberSold = soldDrink.getOrDefault(drinkType, 0);
                    return drinkType.lineReport(numberSold);
                })
                .forEach(printer::print);
    }
}
