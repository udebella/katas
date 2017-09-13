package coffee;

import java.util.Arrays;
import java.util.Optional;

public enum DrinkType {
    COFFEE("Coffee", "C"),
    CHOCOLATE("Chocolate", "H");

    private final String name;
    private final String command;

    DrinkType(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public static Optional<String> getCommandFromName(String name) {
        return Arrays.stream(values())
                .filter(drinkType -> drinkType.getName().equals(name))
                .map(DrinkType::getCommand)
                .findAny();
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }
}
