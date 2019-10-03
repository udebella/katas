package kata.coffee.machine;

import kata.coffee.machine.reporting.Repository;

import java.util.List;

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
        final List<String> missingBeveragesCodes = Beverages.missingBeverages(beverageQuantityChecker);

        if (missingBeveragesCodes.isEmpty()) {
            drinkMaker.process(order.format());
            repository.track(order);
        }

        missingBeveragesCodes
                .stream()
                .peek(emailNotifier::notifyMissingDrink)
                .map(code -> "M:Missing " + code + ", notification sent")
                .forEach(drinkMaker::process);
    }
}
