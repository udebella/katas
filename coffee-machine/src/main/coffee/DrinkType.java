package coffee;

import java.util.Optional;
import java.util.stream.Stream;

public enum DrinkType {
    COFFEE("Coffee", "C", 60),
    ORANGE_JUICE("Orange Juice", "O", 60),
    CHOCOLATE("Chocolate", "H", 50),
    TEA("Tea", "T", 40);

    private static final String COMMAND_SEPARATOR = ":";
    private static final String LINE_REPORT_SEPARATOR = " | ";
    private static final String TOUILLETTE = "0";
    private static final String EXTRA_HOT = "h";
    private static final String MESSAGE_COMMAND = "M";

    private final String name;
    private final String command;
    private final int price;

    DrinkType(String name, String command, int price) {
        this.name = name;
        this.command = command;
        this.price = price;
    }

    static Optional<DrinkType> findByName(String drinkType) {
        return Stream.of(values())
                .filter(dt -> dt.name.equals(drinkType))
                .findAny();
    }

    public String drinkMakerFormat(CustomerCommand customerCommand) {
        if (checkEnoughMoney(customerCommand)) {
            return formatErrorMessage("Not enough money : " + (this.price - customerCommand.getMoney()) + " is missing");
        }

        return formatCommand(customerCommand);
    }

    public String formatErrorMessage(String message) {
        return MESSAGE_COMMAND + COMMAND_SEPARATOR + message;
    }

    private boolean checkEnoughMoney(CustomerCommand customerCommand) {
        return this.price > customerCommand.getMoney();
    }

    private String formatCommand(CustomerCommand customerCommand) {
        return command +
                extraHot(customerCommand.isExtraHot()) +
                sugar(customerCommand.getSugarNumber());
    }

    private String extraHot(boolean isExtraHot) {
        StringBuilder result = new StringBuilder();
        if (isExtraHot) {
            result.append(EXTRA_HOT);
        }
        return result.toString();
    }

    private String sugar(int sugarNumber) {
        StringBuilder result = new StringBuilder();
        if (sugarNumber > 0) {
            result.append(COMMAND_SEPARATOR)
                    .append(sugarNumber)
                    .append(COMMAND_SEPARATOR)
                    .append(TOUILLETTE);
        } else {
            result
                    .append(COMMAND_SEPARATOR)
                    .append(COMMAND_SEPARATOR);
        }
        return result.toString();
    }

    public String lineReport(int numberSold) {
        return name + LINE_REPORT_SEPARATOR
                + numberSold + LINE_REPORT_SEPARATOR
                + numberSold * price;
    }

    public String getCommand() {
        return command;
    }
}
