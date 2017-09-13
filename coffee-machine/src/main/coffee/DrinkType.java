package coffee;

import java.util.Optional;
import java.util.stream.Stream;

public enum DrinkType {
    COFFEE("Coffee", "C", 60),
    ORANGE_JUICE("Orange Juice", "O", 60),
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
        if (this.price > customerCommand.getMoney()) {
            return "M:Not enough money : " + (this.price - customerCommand.getMoney()) + " is missing";
        }

        StringBuilder result = new StringBuilder();
        result.append(command);

        final int sugarNumber = customerCommand.getSugarNumber();
        if (customerCommand.isExtraHot()) {
            result.append("h");
        }
        if (sugarNumber > 0) {
            result.append(":")
                    .append(sugarNumber)
                    .append(":0");
        } else {
            result.append("::");
        }
        return result.toString();
    }

    public String lineReport(int numberSold) {
        return name + " | " + numberSold + " | " + numberSold * price;
    }
}
