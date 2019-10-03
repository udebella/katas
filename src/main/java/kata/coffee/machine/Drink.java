package kata.coffee.machine;

import java.util.Optional;

public interface Drink {
    String format();

    Optional<Amount> isMoreExpensiveThan(Amount amount);
}
