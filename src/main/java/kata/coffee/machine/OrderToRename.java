package kata.coffee.machine;

public class OrderToRename implements Order {
    private final Drink drink;
    private final Amount amount;

    public OrderToRename(Drink drink, Amount amount) {
        this.drink = drink;
        this.amount = amount;
    }

    @Override
    public String format() {
        return amount.isEnoughFor(drink)
                .map(missingAmount -> "M:Missing " + missingAmount.format())
                .orElse(drink.format());
    }

}
