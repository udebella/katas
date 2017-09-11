package fr.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateTest {
    @Test
    public void rates_can_be_compared() throws Exception {
        final Rate rate1 = new Rate(0);
        final Rate rate2 = new Rate(0);

        assertThat(rate1).isEqualTo(rate2);
    }

    @Test
    public void zero_rate_can_be_divided_by_one() throws Exception {
        assertThat(new Rate(0).divide(new Rate(1))).isEqualTo(new Rate(0));
    }

    @Test
    public void any_rate_can_be_divided_by_one() throws Exception {
        assertThat(new Rate(12).divide(new Rate(1))).isEqualTo(new Rate(12));
    }

    @Test(expected = ArithmeticException.class)
    public void rate_cannot_be_divided_by_zero() throws Exception {
        new Rate(12).divide(new Rate(0));
    }

    @Test
    public void rate_divided_by_itself_should_be_one() throws Exception {
        final Rate rate = new Rate(2);

        assertThat(rate.divide(rate)).isEqualTo(new Rate(1));
    }

    @Test
    public void rate_can_be_divided_by_any_non_zero_rate() throws Exception {
        assertThat(new Rate(4).divide(new Rate(2))).isEqualTo(new Rate(2));
    }
}