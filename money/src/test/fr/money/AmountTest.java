package fr.money;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AmountTest {
    @Test
    public void should_allow_to_create_amount_from_value() throws Exception {
        Assertions.assertThat(new Amount(0)).isNotNull();
    }
}