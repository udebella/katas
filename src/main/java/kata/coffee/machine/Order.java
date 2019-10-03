package kata.coffee.machine;

public class Order {
    private final Drink drink;
    private final Amount amount;

    private Order(Drink drink, Amount amount) {
        this.drink = drink;
        this.amount = amount;
    }

    public static Order of(Drink drink, Amount amount) {
        return new Order(drink, amount);
    }

    public String format() {
        return amount.isEnoughFor(drink)
                .map(missingAmount -> "M:Missing " + missingAmount.format())
                .orElse(drink.format());
    }
}
