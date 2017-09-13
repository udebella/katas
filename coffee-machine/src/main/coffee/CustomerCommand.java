package coffee;

public class CustomerCommand {
    private final String drinkType;
    private final int sugarNumber;
    private final boolean extraHot;
    private final int money;

    public CustomerCommand(String drinkType) {
        this(drinkType, 0);
    }

    public CustomerCommand(String drinkType, int sugarNumber) {
        this(drinkType, sugarNumber, false);
    }

    public CustomerCommand(String drinkType, int sugarNumber, boolean extraHot) {
        this(drinkType, sugarNumber, extraHot, 100);
    }

    public CustomerCommand(String drinkType, int sugarNumber, boolean extraHot, int money) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
        this.extraHot = extraHot;
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

    public boolean isExtraHot() {
        return extraHot;
    }
}
