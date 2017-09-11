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

    @Test
    public void amounts_should_not_be_rounded_when_converted_to_cents() throws Exception {
        final Amount cents = new Amount(234).cents();
        final Amount otherAmountAsCents = new Amount(200).cents();

        assertThat(cents).isNotEqualTo(otherAmountAsCents);
    }

    @Test
    public void applying_one_rate_should_update_the_amount() throws Exception {
        final Amount amount = new Amount(1);
        final Rate rate = new Rate(1);
        final Amount expectedAmount = new Amount(1);

        assertThat(amount.apply(rate)).isEqualTo(expectedAmount);
    }

    @Test
    public void applying_rate_should_return_a_new_amount() throws Exception {
        final Amount amount = new Amount(1);
        final Rate rate = new Rate(2);
        final Amount expectedAmount = new Amount(2);

        assertThat(amount.apply(rate)).isEqualTo(expectedAmount);
    }

    @Test
    public void adding_zero_amount_to_zero_amount_should_produce_zero_amount() throws Exception {
        final Amount zero = new Amount(0);

        assertThat(zero.add(zero)).isEqualTo(zero);
    }

    @Test
    public void adding_non_zero_to_zero() throws Exception {
        final Amount ten = new Amount(10);
        final Amount zero = new Amount(0);

        assertThat(ten.add(zero)).isEqualTo(ten);
    }
}