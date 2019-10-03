package kata.coffee.machine;

import java.util.Optional;

public class SugarDrink implements Drink {
    private final Drink drink;
    private final int sugarNumber;

    public SugarDrink(Drink drink, int sugarNumber) {
        this.drink = drink;
        this.sugarNumber = sugarNumber;
    }

    @Override
    public Optional<Amount> isMoreExpensiveThan(Amount amount) {
        return drink.isMoreExpensiveThan(amount);
    }

    @Override
    public String format() {
        if (sugarNumber == 0) {
            return drink.format() + "::";
        }
        return drink.format() + ":" + sugarNumber + ":0";
    }
}
