package kata.coffee.machine;

public class Order {
    private final Drink drink;
    private final Amount amount;

    private Order(Drink drink, Amount amount) {
        this.drink = drink;
        this.amount = amount;
    }

    public String format() {
        return amount.isEnoughFor(drink)
                .map(missingAmount -> "M:Missing " + missingAmount.format())
                .orElse(drink.format());
    }

    public static OrderBuilder newBuilder() {
        return new OrderBuilder();
    }

    public static final class OrderBuilder {
        private int sugarNumber = 0;
        private boolean isExtraHot = false;
        private Drinks drink;
        private Amount amount = Amount.of(0);

        private OrderBuilder() {
        }

        public OrderBuilder withDrink(Drinks drink) {
            this.drink = drink;
            return this;
        }

        public OrderBuilder extraHot() {
            this.isExtraHot = true;
            return this;
        }

        public OrderBuilder withSugar(int sugarNumber) {
            this.sugarNumber = sugarNumber;
            return this;
        }

        public OrderBuilder withAmount(int amount) {
            this.amount = Amount.of(amount);
            return this;
        }

        public Order build() {
            Drink d = drink;
            if (isExtraHot) {
                d = new ExtraHot(d);
            }
            return new Order(new SugarDrink(d, sugarNumber), amount);
        }
    }
}
