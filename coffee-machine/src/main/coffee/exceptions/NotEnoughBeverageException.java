package coffee.exceptions;

import coffee.DrinkType;

public class NotEnoughBeverageException extends Exception {
    public NotEnoughBeverageException() {
        super(DrinkType.formatErrorMessage("Not enough beverage"));
    }
}
