package fr.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test
    public void should_allow_to_create_amount_from_value() throws Exception {
        final Amount amount = new Amount(0);

        assertThat(amount).isNotNull();
    }

    @Test
    public void amounts_can_be_compared() throws Exception {
        final Amount zero1 = new Amount(0);
        final Amount zero2 = new Amount(0);

        assertThat(zero1).isEqualTo(zero2);
    }

    @Test
    public void amount_can_be_converted_to_cents() throws Exception {
        final Amount cents = new Amount(0).cents();

        assertThat(cents).isNotNull();
    }

    @Test
    public void amount_different_from_zero_should_be_divided_by_100_when_converted_to_cents() throws Exception {
        final Amount cents = new Amount(100).cents();
        final Amount amount = new Amount(1);

        assertThat(cents).isEqualTo(amount);
    }
}