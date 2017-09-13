package coffee;

import java.util.stream.Stream;

public class CoffeeMachine {

    public String handle(CustomerCommand customerCustomer) {
        return  Stream.of(DrinkType.values())
                .filter(drinkType -> drinkType.getPrice() <= customerCustomer.getMoney() )
                .filter(drinkType -> drinkType.getName().equals(customerCustomer.getDrinkType()))
                .map(DrinkType::getCommand)
                .findAny()
                .map(command -> {
                    final int sugarNumber = customerCustomer.getSugarNumber();
                    if (sugarNumber > 0) {
                        return command + ":" + sugarNumber + ":0";
                    }
                    return command + "::";
                }).orElse("M:Not enough money");
    }
}
