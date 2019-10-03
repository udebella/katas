package kata.coffee.machine;

import java.util.Optional;

public enum Drink implements CommandMaker {
    COFFEE("C", Amount.of(60)),
    TEA("T", Amount.of(40)),
    CHOCOLATE("H", Amount.of(50));
    private final String code;
    private final Amount price;

    Drink(String code, Amount price) {
        this.code = code;
        this.price = price;
    }

    public String format() {
        return code;
    }

    public Optional<Amount> isMoreExpensiveThan(Amount amount) {
        return amount.isEnoughFor(price);
    }
}
