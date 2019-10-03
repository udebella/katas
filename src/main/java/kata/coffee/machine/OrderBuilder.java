package kata.coffee.machine;

import kata.coffee.machine.drinks.Drink;
import kata.coffee.machine.drinks.Drinks;
import kata.coffee.machine.drinks.ExtraHot;
import kata.coffee.machine.drinks.SugarDrink;

public final class OrderBuilder {
    private int sugarNumber = 0;
    private boolean isExtraHot = false;
    private Drinks drink;
    private Amount amount = Amount.of(0);

    private OrderBuilder() {
    }

    public static OrderBuilder newBuilder() {
        return new OrderBuilder();
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
