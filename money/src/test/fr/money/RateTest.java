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
}