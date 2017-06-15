import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralsTest {
    @Test
    public void should_append_I_for_values_above_simple_values() throws Exception {
        assertEquals("II", RomanNumerals.convert(2));
        assertEquals("III", RomanNumerals.convert(3));
        assertEquals("VI", RomanNumerals.convert(6));
        assertEquals("VII", RomanNumerals.convert(7));
        assertEquals("VIII", RomanNumerals.convert(8));
        assertEquals("XV", RomanNumerals.convert(15));
        assertEquals("XVIII", RomanNumerals.convert(18));
        assertEquals("XX", RomanNumerals.convert(20));
    }

    @Test
    public void should_return_expected_letter_for_simple_value() throws Exception {
        assertEquals("I", RomanNumerals.convert(1));
        assertEquals("V", RomanNumerals.convert(5));
        assertEquals("X", RomanNumerals.convert(10));
        assertEquals("L", RomanNumerals.convert(50));
        assertEquals("C", RomanNumerals.convert(100));
    }

    @Test
    public void should_prepend_I_for_values_below_simple_values() throws Exception {
        assertEquals("IV", RomanNumerals.convert(4));
        assertEquals("IX", RomanNumerals.convert(9));
    }

    @Test
    public void should_prepend_X_for_values_below_simple_values() throws Exception {
        assertEquals("XL", RomanNumerals.convert(40));
    }

    @Test
    public void should_work_with45() throws Exception {
        assertEquals("XLV", RomanNumerals.convert(45));

    }

    @Test
    public void should_work_with94() throws Exception {
        assertEquals("XCIV", RomanNumerals.convert(94));
        assertEquals("CXCIV", RomanNumerals.convert(194));
    }
}
