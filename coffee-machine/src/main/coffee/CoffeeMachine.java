package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class CoffeeMachine {
    private Map<DrinkType, Integer> soldDrink = new HashMap<>();
    private BeverageQuantityChecker beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    public CoffeeMachine(BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    public String handle(CustomerCommand customerCommand) {
        final Optional<DrinkType> drinkType = DrinkType.getDrinkType(customerCommand.getDrinkType());
        drinkType.ifPresent(dt -> {
            final Integer numberSold = soldDrink.getOrDefault(dt, 0);
            soldDrink.put(dt, numberSold + 1);
        });
        return drinkType
                .map(dt -> dt.formatMessage(customerCommand, beverageQuantityChecker, emailNotifier))
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
