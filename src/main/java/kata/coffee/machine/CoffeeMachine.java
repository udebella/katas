package kata.coffee.machine;

import kata.coffee.machine.reporting.Repository;

public class CoffeeMachine {
    private final DrinkMaker drinkMaker;
    private final Repository repository;
    private final EmailNotifier emailNotifier;
    private final BeverageQuantityChecker beverageQuantityChecker;

    public CoffeeMachine(DrinkMaker drinkMaker, Repository repository, EmailNotifier emailNotifier, BeverageQuantityChecker beverageQuantityChecker) {
        this.drinkMaker = drinkMaker;
        this.repository = repository;
        this.emailNotifier = emailNotifier;
        this.beverageQuantityChecker = beverageQuantityChecker;
    }

    public void make(Order order) {
        if (beverageQuantityChecker.isEmpty("water")) {
            emailNotifier.notifyMissingDrink("water");
            drinkMaker.process("M:Missing water, notification sent");
        } else if (beverageQuantityChecker.isEmpty("milk")) {
            emailNotifier.notifyMissingDrink("milk");
            drinkMaker.process("M:Missing milk, notification sent");
        } else {
            drinkMaker.process(order.format());
            repository.track(order);
        }
    }
}
