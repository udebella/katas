package coffee;

import java.util.Optional;
import java.util.stream.Stream;

public enum DrinkType {
    COFFEE("Coffee", "C", 60),
    CHOCOLATE("Chocolate", "H", 50),
    TEA("Tea", "T", 40);

    private final String name;
    private final String command;
    private final int price;

    DrinkType(String name, String command, int price) {
        this.name = name;
        this.command = command;
        this.price = price;
    }

    static Optional<DrinkType> getDrinkType(String drinkType) {
        return Stream.of(values())
                .filter(dt -> dt.name.equals(drinkType))
                .findAny();
    }

    public String formatMessage(CustomerCommand customerCommand) {
        if (this.price <= customerCommand.getMoney()) {
            final int sugarNumber = customerCommand.getSugarNumber();
            if (sugarNumber > 0) {
                return this.command + ":" + sugarNumber + ":0";
            }
            return this.command + "::";
        }
        return "M:Not enough money : 50 is missing";
    }

}
