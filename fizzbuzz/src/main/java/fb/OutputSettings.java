package fb;

/**
 * Created by Ubu on 20/03/2017.
 */
public enum OutputSettings {
    MULTIPLE_THREE("fizz", 3),
    MULTIPLE_FIVE("buzz", 5),
    MULTIPLE_TEN("toto", 7)
    ;

    private final int value;
    private String output;

    OutputSettings(String output, int value) {
        this.output = output;
        this.value = value;
    }

    public String getOutput() {
        return output;
    }

    public int getValue() {
        return value;
    }
}
