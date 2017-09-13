package coffee;

public class CoffeeMachine {
    public String handle(CustomerCommand customerCustomer) {
        if (customerCustomer.getDrinkType().equals("Chocolate")) {
            return "H::";
        }
        if (customerCustomer.getDrinkType().equals("Coffee")) {
            return "C::";
        }
        if (customerCustomer.getSugarNumber() == 1) {
            return "T:1:0";
        }
        return "T::";
    }
}
