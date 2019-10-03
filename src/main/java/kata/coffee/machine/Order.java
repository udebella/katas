package kata.coffee.machine;

public class Order {
    private final Drink drink;
    private final SugarNumber nbSugar;

    private Order(Drink drink, SugarNumber nbSugar) {
        this.drink = drink;
        this.nbSugar = nbSugar;
    }

    public static Order of(Drink drink, SugarNumber nbSugar) {
        return new Order(drink, nbSugar);
    }

    public String format() {
        return drink.format() + ":" + nbSugar.format();
    }
}
