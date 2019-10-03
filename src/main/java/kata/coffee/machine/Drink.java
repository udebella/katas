package kata.coffee.machine;

public enum Drink {
    COFFEE("C"),
    TEA("T");
    private final String code;

    Drink(String code) {
        this.code = code;
    }

    public String format() {
        return code;
    }
}
