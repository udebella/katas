package kata.coffee.machine;

public enum Drink {
    COFFEE("C"),
    TEA("T"),
    CHOCOLATE("H");
    private final String code;

    Drink(String code) {
        this.code = code;
    }

    public String format() {
        return code;
    }
}
