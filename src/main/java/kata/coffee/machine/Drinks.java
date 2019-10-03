package kata.coffee.machine;

import java.util.Optional;

public enum Drinks implements Drink {
    COFFEE("C", Amount.of(60)),
    TEA("T", Amount.of(40)),
    CHOCOLATE("H", Amount.of(50)),
    ORANGE_JUICE("O", Amount.of(50));
    private final String code;
    private final Amount price;

    Drinks(String code, Amount price) {
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
