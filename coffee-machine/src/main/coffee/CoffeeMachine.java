package coffee;

import java.util.NoSuchElementException;

public class CoffeeMachine {

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElseThrow(NoSuchElementException::new);
    }

    public void report(Printer printer) {
        printer.print("Drink type   | Number sold | Money earned");
        for (DrinkType drinkType : DrinkType.values()) {
            printer.print(drinkType.getName() + " | 0 | 0");
        }
    }
}
