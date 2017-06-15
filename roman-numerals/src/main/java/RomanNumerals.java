public enum RomanNumerals {
    ONE(1, "I"),
    FOUR(4, "IV"),
    FIVE(5, "V"),
    NINE(9, "IX"),
    TEN(10, "X"),
    FOURTY(40, "XL"),
    FIFTY(50, "L"),
    NINETY(90, "XC"),
    ONE_HUNDRED(100, "C");

    private final int value;
    private final String letter;

    RomanNumerals(int value, String letter) {
        this.value = value;
        this.letter = letter;
    }

    public static String convert(int number) {
        StringBuilder returnValue = new StringBuilder("");

        for (int i = RomanNumerals.values().length; i > 0; i--) {
            RomanNumerals sv = RomanNumerals.values()[i - 1];
            while (number >= sv.value) {
                returnValue.append(sv.letter);
                number -= sv.value;
            }
        }

        return returnValue.toString();
    }
}
