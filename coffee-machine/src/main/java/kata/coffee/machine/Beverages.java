package kata.coffee.machine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Beverages {
    WATER("water"),
    MILK("milk");

    private final String code;

    Beverages(String code) {
        this.code = code;
    }

    public static List<String> missingBeverages(BeverageQuantityChecker beverageQuantityChecker) {
        return Stream.of(values())
                .map(beverage -> beverage.code)
                .filter(beverageQuantityChecker::isEmpty)
                .collect(Collectors.toList());
    }
}
