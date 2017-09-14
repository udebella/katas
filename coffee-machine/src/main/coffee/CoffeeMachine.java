package coffee;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

public class CoffeeMachine {
    private final Map<DrinkType, Integer> soldDrink = new HashMap<>();
    private final BeverageQuantityChecker beverageQuantityChecker;
    private final EmailNotifier emailNotifier;

    public CoffeeMachine(BeverageQuantityChecker beverageQuantityChecker, EmailNotifier emailNotifier) {
        this.beverageQuantityChecker = beverageQuantityChecker;
        this.emailNotifier = emailNotifier;
    }

    public String handle(CustomerCommand customerCommand) throws InvalidCommandException {
        final DrinkType drinkType = DrinkType.findByName(customerCommand.getDrinkType())
                .orElseThrow(InvalidCommandException::new);

        if (beverageQuantityChecker.isEmpty(drinkType.getCommand())) {
            emailNotifier.notifyMissingDrink(drinkType.getCommand());
            return drinkType.formatErrorMessage("Not enough beverage");
        }
        if (drinkType.checkEnoughMoney(customerCommand)) {
            return drinkType.formatErrorMessage("Not enough money : " + (drinkType.getPrice() - customerCommand.getMoney()) + " is missing");
        }
        addSoldReport(drinkType);
        return drinkType.drinkMakerFormat(customerCommand);
    }

    private void addSoldReport(DrinkType dt) {
        final Integer numberSold = soldDrink.getOrDefault(dt, 0);
        soldDrink.put(dt, numberSold + 1);
    }

    public void report(Printer printer) {
        printer.print("Drink type   | Number sold | Money earned");
        Stream.of(DrinkType.values())
                .map(this::formatLine)
                .forEach(printer::print);
    }

    private String formatLine(DrinkType drinkType) {
        final Integer numberSold = soldDrink.getOrDefault(drinkType, 0);
        return drinkType.lineReport(numberSold);
    }
}
