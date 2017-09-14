package coffee.exceptions;

import coffee.DrinkType;

public class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(int missingMoney) {
        super(DrinkType.formatErrorMessage("Not enough money : " + Math.abs(missingMoney) + " is missing"));
    }
}
