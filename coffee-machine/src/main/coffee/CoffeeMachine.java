package coffee;

import java.util.NoSuchElementException;

public class CoffeeMachine {

    public String handle(CustomerCommand customerCommand) {
        return DrinkType
                .getDrinkType(customerCommand.getDrinkType())
                .map(drinkType -> drinkType.formatMessage(customerCommand))
                .orElseThrow(NoSuchElementException::new);
    }

}
