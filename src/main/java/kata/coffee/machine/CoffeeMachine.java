package kata.coffee.machine;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private final Repository repository;

    public CoffeeMachine(DrinkMaker drinkMaker, Repository repository) {
        this.drinkMaker = drinkMaker;
        this.repository = repository;
    }

    public void make(Order order) {
        drinkMaker.process(order.format());
        repository.track(order);
    }
}
