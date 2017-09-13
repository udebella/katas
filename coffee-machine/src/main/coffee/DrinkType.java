package coffee;

import java.util.Optional;
import java.util.stream.Stream;

public enum DrinkType {
    COFFEE("Coffee", "C"),
    CHOCOLATE("Chocolate", "H"),
    TEA("Tea", "T");

    private final String name;
    private final String command;

    DrinkType(String name, String command) {
        this.name = name;
        this.command = command;
    }

    public static Optional<String> getCommandFromName(String name) {
        return Stream.of(values())
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
