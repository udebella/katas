package kata.coffee.machine;

public class SugarNumber {
    private final int number;

    public SugarNumber(int number) {
        this.number = number;
    }

    public String format() {
        if (number == 0) {
            return ":";
        }
        return number + ":0";
    }
}
