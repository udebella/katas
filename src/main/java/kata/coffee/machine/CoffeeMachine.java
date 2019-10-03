package kata.coffee.machine;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;

    public CoffeeMachine(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    public void make(Order order) {
        drinkMaker.process("T:1:0");
    }
}
