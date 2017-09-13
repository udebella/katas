package coffee;

public enum DrinkType {
    COFFEE("Coffee", "C" , 60),
    CHOCOLATE("Chocolate", "H" ,50),
    TEA("Tea", "T" ,40);

    private final String name;
    private final String command;
    private final int price;

    DrinkType(String name, String command, int price) {
        this.name = name;
        this.command = command;
        this.price = price;
    }

    public  int getPrice() {
        return price;
    }

    public String getCommand() {
        return command;
    }

    public String getName() {
        return name;
    }
}
