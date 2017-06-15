import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RpnCalculatorTest {
    @Test
    public void should_return_4_when_20_div_5() {
        int value = RpnCalculator.calculate("20 5 /");
        assertEquals(4, value);
    }

    @Test
    public void should_return_10_when_20_div_2() {
        int value = RpnCalculator.calculate("20 2 /");
        assertEquals(10, value);
    }

    @Test
    public void should_return_2_when_20_div_5_div_2() throws Exception {
        int value = RpnCalculator.calculate("20 5 / 2 /");
        assertEquals(2, value);
    }

    @Test
    public void should_return_3_when_4_add_2_sub_3() throws Exception {
        int value = RpnCalculator.calculate("4 2 + 3 -");
        assertEquals(3, value);
    }
}
