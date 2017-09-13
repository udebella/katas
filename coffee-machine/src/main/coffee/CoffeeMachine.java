package coffee;

public class CoffeeMachine {
    public String handle(CustomerCommand customerCustomer) {
        if (customerCustomer.getDrinkType().equals("Chocolate")) {
            return "H::";
        }
        return "T::";
    }
}
