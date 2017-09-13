package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CoffeeMachine {
    private Map<DrinkType,Integer> soldDrink = new HashMap<>();
    private BeverageQuantityChecker beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    public CoffeeMachine(BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .filter(drinkType -> {
                    final boolean EnoughDrink = !beverageQuantityChecker.isEmpty(drinkType.getName());
                    if(!EnoughDrink){
                        emailNotifier.notifyMissingDrink(drinkType.getName());
                    }
                    return EnoughDrink;
                })
                .map(drinkType -> {
                    final Integer numberSold = soldDrink.getOrDefault(drinkType, 0);
                    soldDrink.put(drinkType, numberSold + 1);
                    return drinkType;
                })
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElse("");
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
