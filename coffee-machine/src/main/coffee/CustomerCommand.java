package coffee;

public class CustomerCommand {
    private final String drinkType;
    private final int sugarNumber;

    public CustomerCommand(String drinkType, int sugarNumber) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
    }
}
