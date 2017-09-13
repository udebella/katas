package coffee;

public class CoffeeMachine {
    public String handle(CustomerCommand customerCustomer) {
        return DrinkType.getCommandFromName(customerCustomer.getDrinkType())
                .map(command -> {
                    if (customerCustomer.getSugarNumber() == 2) {
                        return command + ":2:0";
                    }
                    if (customerCustomer.getSugarNumber() == 1) {
                        return command + ":1:0";
                    }
                    return command + "::";
                }).get();
    }
}
