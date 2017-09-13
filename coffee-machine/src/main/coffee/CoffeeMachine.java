package coffee;

public class CoffeeMachine {
    public String handle(CustomerCommand customerCustomer) {
        return DrinkType.getCommandFromName(customerCustomer.getDrinkType())
                .map(command -> {
                    final int sugarNumber = customerCustomer.getSugarNumber();
                    if (sugarNumber > 0) {
                        return command + ":" + sugarNumber + ":0";
                    }
                    return command + "::";
                }).get();
    }
}
