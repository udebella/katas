package kata.coffee.machine;

public class Order {
    private final Drink drink;

    private Order(Drink drink) {
        this.drink = drink;
    }

    public static Order of(Drink drink, int nbSugar) {
        return new Order(drink);
    }

    public String format() {
        return drink.format() + ":1:0";
    }
}
