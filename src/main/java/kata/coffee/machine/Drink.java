package kata.coffee.machine;

public enum Drink {
    COFFEE("C", 60),
    TEA("T", 40),
    CHOCOLATE("H", 50);
    private final String code;
    private final int price;

    Drink(String code, int price) {
        this.code = code;
        this.price = price;
    }

    public String format() {
        return code;
    }

    public int getPrice() {
        return price;
    }
}
