package coffee;

public class CustomerCommand {
    private final String drinkType;
    private final int sugarNumber;
    private final int money;

    public CustomerCommand(String drinkType, int sugarNumber) {
        this(drinkType, sugarNumber, 100);
    }

    public CustomerCommand(String drinkType, int sugarNumber, int money) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
        this.money = money;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public int getSugarNumber() {
        return sugarNumber;
    }

    public int getMoney() {
        return money;
    }
}
