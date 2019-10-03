package kata.coffee.machine.drinks;

import kata.coffee.machine.Amount;
import kata.coffee.machine.Repository;

import java.util.Optional;

public interface Drink {
    String format();

    Optional<Amount> isMoreExpensiveThan(Amount amount);

    void register(Repository repository);
}
