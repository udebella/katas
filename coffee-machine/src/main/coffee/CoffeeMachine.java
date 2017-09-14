package coffee;

import coffee.exceptions.InvalidCommandException;
import coffee.exceptions.NotEnoughBeverageException;
import coffee.exceptions.NotEnoughMoneyException;
import coffee.interfaces.BeverageQuantityChecker;
import coffee.interfaces.CustomerCommand;
import coffee.interfaces.EmailNotifier;
import coffee.interfaces.Printer;

import java.util.HashMap;
import java.util.Map;
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
        try {
            final DrinkType drinkType = DrinkType.findByName(customerCommand.getDrinkType())
                    .orElseThrow(InvalidCommandException::new);
            checkEnoughBeverage(drinkType);
            checkEnoughMoney(drinkType, customerCommand);
            addSoldReport(drinkType);
            return drinkType.drinkMakerFormat(customerCommand);
        } catch (NotEnoughBeverageException | NotEnoughMoneyException e) {
            return e.getMessage();
        }
    }

    private void checkEnoughBeverage(DrinkType drinkType) throws NotEnoughBeverageException {
        if (beverageQuantityChecker.isEmpty(drinkType.getCommand())) {
            emailNotifier.notifyMissingDrink(drinkType.getCommand());
            throw new NotEnoughBeverageException();
        }
    }

    private void checkEnoughMoney(DrinkType drinkType, CustomerCommand customerCommand) throws NotEnoughMoneyException {
        final int missingMoney = drinkType.hasEnoughMoney(customerCommand);
        if (missingMoney > 0) {
            throw new NotEnoughMoneyException(missingMoney);
        }
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
