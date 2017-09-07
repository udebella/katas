package fr.money;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {
    @Test
    public void should_allow_to_create_amount_from_value() throws Exception {
        final Amount amount = new Amount(0);

        assertThat(amount).isNotNull();
    }
}