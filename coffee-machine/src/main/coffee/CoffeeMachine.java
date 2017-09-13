package coffee;

public class CoffeeMachine {
    public String handle(CustomerCommand customerCustomer) {
        return DrinkType.getCommandFromName(customerCustomer.getDrinkType())
                .map(command -> command + "::")
                .orElseGet(() -> {
                    if (customerCustomer.getSugarNumber() == 1) {
                        return "T:1:0";
                    }
                    return "T::";
                });
    }
}
