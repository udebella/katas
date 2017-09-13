package coffee;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class CoffeeMachine {

    public String handle(CustomerCommand customerCommand) {
        final DrinkType drinkType = Stream.of(DrinkType.values())
                .filter(dt -> dt.getName().equals(customerCommand.getDrinkType()))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
        if (drinkType.getPrice() <= customerCommand.getMoney()) {
            final int sugarNumber = customerCommand.getSugarNumber();
            if (sugarNumber > 0) {
                return drinkType.getCommand() + ":" + sugarNumber + ":0";
            }
            return drinkType.getCommand() + "::";
        }
        return "M:Not enough money : 50 is missing";
    }
}
